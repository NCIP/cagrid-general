/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package org.globus.wsrf.container;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.security.auth.Subject;
import javax.xml.rpc.Stub;

import org.apache.axis.AxisEngine;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.globus.axis.gsi.GSIConstants;
import org.globus.gsi.gssapi.JaasGssUtil;
import org.globus.gsi.gssapi.auth.NoAuthorization;
import org.globus.net.ServerSocketFactory;
import org.globus.util.I18n;
import org.globus.wsrf.WSRFConstants;
import org.globus.wsrf.client.BaseClient;
import org.globus.wsrf.config.ContainerConfig;
import org.globus.wsrf.encoding.ObjectDeserializer;
import org.globus.wsrf.impl.security.descriptor.ContainerSecurityConfig;
import org.globus.wsrf.utils.FaultHelper;
import org.globus.wsrf.utils.Resources;
import org.ietf.jgss.GSSCredential;
import org.oasis.wsrf.properties.GetResourceProperty;
import org.oasis.wsrf.properties.GetResourcePropertyResponse;
import org.oasis.wsrf.properties.WSResourcePropertiesServiceLocator;
import org.oasis.wsrf.servicegroup.EntryType;

/**
 * Http Server that can be used in embedded or standalone mode to host
 * Axis services.
 */
public class ServiceContainer {

    static I18n i18n = I18n.getI18n(Resources.class.getName());

    public static final String HARD_SHUTDOWN = "hardShutdown";

    public static final int DEFAULT_PORT = 8080; //default port
    public static final int DEFAULT_SECURE_PORT = 8443; //default secure port

    public static final String PORT = "container.port";
    public static final String CLASS = "container.class";
    public static final String MAIN_THREAD = "container.mainThread";
    public static final String THREADS = "container.threads";
    public static final String SERVER_CONFIG = "container.server.config";
    public static final String CONTAINER_DESCRIPTOR =
        "container.descriptor";

    protected URL url;
    protected ServiceDispatcher dispatcher;
    protected Map properties;
    private int references = 0;

    protected static Hashtable containers = new Hashtable();

    private static Log logger =
        LogFactory.getLog(ServiceContainer.class.getName());

    public static ServiceContainer createContainer(boolean isMainThread)
        throws ContainerException {
        Properties props = new Properties();
        props.put(MAIN_THREAD, (isMainThread) ? Boolean.TRUE : Boolean.FALSE);
        return ServiceContainer.createContainer(props);
    }

    public static ServiceContainer createContainer(boolean isMainThread,
                                                   int port)
        throws ContainerException {
        Properties props = new Properties();
        props.put(MAIN_THREAD, (isMainThread) ? Boolean.TRUE : Boolean.FALSE);
        props.put(PORT, new Integer(port));
        return ServiceContainer.createContainer(props);
    }

    public static synchronized ServiceContainer createContainer(Map properties)
        throws ContainerException {
        if (properties == null) {
            throw new IllegalArgumentException(
                i18n.getMessage("containerPropertiesNotSpecified")
            );
        }

        ServiceContainer container =
            (ServiceContainer) containers.get(properties);

        if (container == null ||
            !container.increaseReferences()) {
            Class containerClass = null;
            String prop = (String) properties.get(CLASS);
            if (prop == null) {
                containerClass = ServiceContainer.class;
            } else {
                try {
                    containerClass = Class.forName(prop);
                } catch (Exception e) {
                    throw new ContainerException(e);
                }

                if (!ServiceContainer.class.isAssignableFrom(containerClass)) {
                    throw new ContainerException(
                        ServiceContainer.i18n.getMessage(
                            "containerClassError", prop));
                }
            }

            try {
                Constructor con =
                    containerClass.getConstructor(new Class[] { Map.class });

                container = (ServiceContainer)
                    con.newInstance(new Object[] { properties });
            } catch (InvocationTargetException e) {
                Throwable ex = e.getTargetException();
                if (ex instanceof SecureContainerException) {
                    throw (SecureContainerException)ex;
                } else if (ex instanceof ContainerException) {
                    throw (ContainerException)ex;
                } else if (ex instanceof Exception) {
                    throw new ContainerException((Exception)ex);
                } else {
                    throw new ContainerException(e);
                }
            } catch (Exception e) {
                throw new ContainerException(e);
            }
        }

        return container;
    }

    /* Used by subclasses only */
    protected ServiceContainer() {
    }

    public ServiceContainer(Map properties) throws ContainerException {
        if (properties == null) {
            throw new IllegalArgumentException(
                i18n.getMessage("containerPropertiesNotSpecified")
            );
        }

        this.properties = properties;

        // get port
        int port = 0;
        Integer portProp = (Integer) properties.get(PORT);

        if (portProp != null) {
            port = portProp.intValue();
        }

        // get main thread
        boolean isMainThread = false;
        Boolean threadProp = (Boolean) properties.get(MAIN_THREAD);

        if (threadProp != null) {
            isMainThread = threadProp.booleanValue();
        }

        // get num of threads
        int threads = -1;
        Integer threadsProp = (Integer) properties.get(THREADS);

        if (threadsProp != null) {
            threads = threadsProp.intValue();
        }

        try {
            start(isMainThread, port, threads);
        } catch (ContainerException e) {
            try {
                close();
            } catch (IOException io) {
            }
            throw e;
        } catch (Exception e) {
            try {
                close();
            } catch (IOException io) {
            }
            throw new ContainerException(
                i18n.getMessage("containerInitError"), e);
        }
    }

    protected ServiceDispatcher createServiceDispatcher() throws Exception {
        return new ServiceDispatcher(this.properties);
    }

    public String getProtocol() {
        return "http";
    }

    protected void start(boolean isMainThread, int port, int threads)
        throws Exception {

        this.dispatcher = createServiceDispatcher();

        ServerSocketFactory factory = ServerSocketFactory.getDefault();
        ServerSocket socket = factory.createServerSocket(port);

        this.dispatcher.setThreads(threads);
        this.dispatcher.setServerSocket(socket);

        String protocol = getProtocol();
        String host = ServiceHost.getHost(this.dispatcher.getAxisEngine());
        int lport = socket.getLocalPort();

        ServiceHost.setDefaults(protocol, host, lport);

        this.dispatcher.init();
        this.dispatcher.start(!isMainThread);

        ContainerConfig engConfig =
            ContainerConfig.getConfig(this.dispatcher.getAxisEngine());
        this.url = new URL(protocol, host, lport,
                           "/" + engConfig.getWSRFLocation());
        logger.debug("Starting server: " + this.url);

        if (logger.isDebugEnabled()) {
            String entropyGenerator = System.getProperty("java.security.egd");
            if (entropyGenerator != null) {
                logger.debug("Using " + entropyGenerator + " as " +
                             "entropy generator.");
            }
        }

        this.references++;
        
        ServiceContainerCollection.register(getURLString(), this);
        containers.put(properties, this);
    }

    protected synchronized boolean increaseReferences() {
        if (this.dispatcher == null || this.dispatcher.isStopped()) {
            return false;
        }
        this.references++;
        return true;
    }

    public synchronized void stop() throws ContainerException {
        if (this.references > 0) {
            this.references--;
        }
        if (this.references == 0) {
            try {
                close();
            } catch (IOException e) {
                throw new ContainerException(
                    i18n.getMessage("containerStopError"), e);
            }
        }
    }

    protected synchronized void close() throws IOException {
        if (this.url != null) {
            logger.debug("Stopping server: " + this.url);
        }
        if (this.dispatcher != null) {
            this.dispatcher.stop();
        }
        if (this.url != null) {
            ServiceContainerCollection.unregister(this.url.toString());
            containers.remove(this.properties);
            logger.debug("Stopped server: " + this.url);
        }
    }

    public boolean isRunning() {
        return !this.dispatcher.isStopped();
    }

    public int getPort() {
        return this.url.getPort();
    }

    public String getHost() {
        return this.url.getHost();
    }

    public String getURLString() {
        return this.url.toString();
    }

    public URL getURL() {
        return this.url;
    }

    public void waitForInit() throws InterruptedException {
        dispatcher.waitForInit();
    }

    public void waitForStop() throws InterruptedException {
        dispatcher.waitForStop();
    }

    public AxisEngine getEngine() {
        return dispatcher.getAxisEngine();
    }


    public static void main(String[] args) {
        //TODO: i18n?
        String usageMsg =
            "Usage: ServiceContainer [options]\n" +
            "Where [options] are:\n" +
            " -help                    Displays this message\n" +
            " -p <port>                Sets container port number\n" +
            " -quiet                   Does not show list of services at startup\n" +
            " -nosec                   Start a non secure (http) container (message\n" +
            "                          security can still be used)\n" + 
            " -containerDesc <file>    Sets container security descriptor file\n" +
            " -profile <name>          Specifies different configuration profile\n" +
            " -debug                   Enables debug mode\n" +
            "";

        int port = -1;
        boolean secure = true;
        boolean quiet = false;
        boolean debug = false;
        String containerDescFile = null;
        String profile = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-p")) {
                if ((i + 1) == args.length) {
                    exit("Error: -p requires an argument.");
                }
                port = Integer.parseInt(args[++i]);
            } else if (args[i].equalsIgnoreCase("-nosec")) {
                secure = false;
            } else if (args[i].equalsIgnoreCase("-debug")) {
                debug = true;
            } else if (args[i].equalsIgnoreCase("-help")) {
                exit(usageMsg);
            } else if (args[i].equalsIgnoreCase("-containerDesc")) {
                if ((i + 1) == args.length) {
                    exit("Error: -containerDesc requires an argument.");
                }
                containerDescFile = args[++i];
            } else if (args[i].equalsIgnoreCase("-quiet")) {
                quiet = true;
            } else if (args[i].equalsIgnoreCase("-profile")) {
                if ((i + 1) == args.length) {
                    exit("Error: -profile requires an argument.");
                }
                profile = args[++i];
            } else {
                exit("Error: argument not recognized: " + args[i]);
            }
        }

        if (port == -1) {
            port = (secure) ? DEFAULT_SECURE_PORT : DEFAULT_PORT;
        }

        Map properties = new Hashtable();
        properties.put(MAIN_THREAD, Boolean.FALSE);
        properties.put(PORT, new Integer(port));

        try {
            // if security descriptor file is set, initialize the
            // container config
            if (containerDescFile != null) {
                ContainerSecurityConfig config = 
                    ContainerSecurityConfig.getConfig(containerDescFile);
            }

            if (profile != null) {
                properties.put(ContainerConfig.CONFIG_PROFILE, profile);
            }

            // start the container
            ServiceContainer container;
            if (secure) {
                container =
                    ServiceContainer.startSecurityContainer(properties);
            } else {
                container = ServiceContainer.createContainer(properties);
            }
            
            // register shutdown thread
            Thread shutdownThread = 
                new ServiceContainerCollection.ShutdownThread();
            Runtime.getRuntime().addShutdownHook(shutdownThread);

            // enable hard shutdown
            System.setProperty(ServiceContainer.HARD_SHUTDOWN, "true");

            // list services if needed
            if (!quiet) {
                listServices(container, secure, debug);
            }

            container.waitForInit();
            container.waitForStop();

            if (!quiet) {
                System.out.println(
                    ServiceContainer.i18n.getMessage("stopServer",
                                                     container.getURLString()));
            }

        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            } else {
                System.err.println(i18n.getMessage("startServerError",
                                                   e.getMessage()));
            }
            System.exit(BaseClient.APPLICATION_ERROR);
        }
    }

    public static ServiceContainer startSecurityContainer(Map properties)
        throws ContainerException {
        properties.put(ServiceContainer.CLASS,
                       "org.globus.wsrf.container.GSIServiceContainer");

        ServiceContainer container =
            ServiceContainer.createContainer(properties);

        ContainerConfig config =
            ContainerConfig.getConfig(container.getEngine());
        config.setOption("httpsPort", String.valueOf(container.getPort()));

        return container;
    }

    private static void exit(String msg) {
        System.err.println(msg);
        System.exit(BaseClient.COMMAND_LINE_ERROR);
    }

    private static void listServices(ServiceContainer container,
                                     boolean secure,
                                     boolean debug) {
        WSResourcePropertiesServiceLocator locator =
            new WSResourcePropertiesServiceLocator();

        String registryService =
            container.getURLString() + "ContainerRegistryService";

        try {
            GetResourceProperty port =
                locator.getGetResourcePropertyPort(new URL(registryService));

            if (secure) {
                ((Stub) port)._setProperty(GSIConstants.GSI_AUTHORIZATION,
                                           NoAuthorization.getInstance());
                Subject subject =
                    ContainerSecurityConfig.getConfig().getSubject();
                GSSCredential cred = JaasGssUtil.getCredential(subject);
                if (cred != null) {
                    ((Stub) port)._setProperty(GSIConstants.GSI_CREDENTIALS,
                                               cred);
                }
            }

            GetResourcePropertyResponse response =
                port.getResourceProperty(WSRFConstants.ENTRY);

            Object[] entries =
                ObjectDeserializer.toObject(response, EntryType.class);

            Arrays.sort(entries, (new Comparator() {
                    public int compare(Object o1, Object o2) {
                        EntryType e1 = (EntryType)o1;
                        EntryType e2 = (EntryType)o2;
                        String a1 = e1.getMemberServiceEPR().getAddress().toString();
                        String a2 = e2.getMemberServiceEPR().getAddress().toString();
                        return a1.compareTo(a2);
                    }
                }));

            System.out.println(
                ServiceContainer.i18n.getMessage("startServer",
                                                 container.getURLString()));

            for (int i=0;i<entries.length;i++) {
                EntryType entry = (EntryType)entries[i];
                System.out.println("[" + (i+1) + "]: " +
                                   entry.getMemberServiceEPR().getAddress());
            }

            // clear the Call object associated with the current thread
            Service.clearCall();
        } catch (Exception e) {
            if (debug) {
                FaultHelper.printStackTrace(e);
            }
            System.err.println(i18n.getMessage(
                                "serviceListError",
                                new Object[] {registryService,
                                              FaultHelper.getMessage(e)}));
            System.exit(BaseClient.APPLICATION_ERROR);
        }
    }

}