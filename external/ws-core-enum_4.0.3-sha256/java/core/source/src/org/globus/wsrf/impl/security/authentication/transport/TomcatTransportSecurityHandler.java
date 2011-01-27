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
package org.globus.wsrf.impl.security.authentication.transport;

import java.security.cert.X509Certificate;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.globus.axis.gsi.GSIConstants;
import org.globus.gsi.gssapi.GSSConstants;
import org.globus.gsi.gssapi.jaas.GlobusPrincipal;
import org.globus.util.I18n;
import org.globus.wsrf.impl.security.authentication.Constants;
import org.globus.wsrf.utils.Resources;
import org.gridforum.jgss.ExtendedGSSContext;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;

public class TomcatTransportSecurityHandler extends BasicHandler {

    private static final I18n i18n = 
        I18n.getI18n(Resources.class.getName());

    private static Log logger =
        LogFactory.getLog(TomcatTransportSecurityHandler.class.getName());

    public void invoke(MessageContext msgContext) throws AxisFault {
        logger.debug("Enter: invoke");

        Object tmp = msgContext.getProperty(
            HTTPConstants.MC_HTTP_SERVLETREQUEST);

        if((tmp == null) || !(tmp instanceof HttpServletRequest)) {
            return;
        }

        HttpServletRequest req = (HttpServletRequest) tmp;

        //TODO: Not sure if the below is still necessary
        String url = req.getRequestURL().toString();
        tmp = msgContext.getProperty(MessageContext.TRANS_URL);
        if(tmp == null && url != null) {
            msgContext.setProperty(MessageContext.TRANS_URL, url);
        }

        Subject subject = getSubject(msgContext);

        tmp = req.getAttribute(GSIConstants.GSI_USER_DN);
        if(tmp != null) {
            subject.getPrincipals().add(new GlobusPrincipal((String) tmp));
        }

        GSSContext context = (GSSContext)
            req.getAttribute(GSIConstants.GSI_CONTEXT);
        if(context != null) {
            msgContext
                .setProperty(Constants.TRANSPORT_SECURITY_CONTEXT, context);
            if (context.getConfState()) {
                msgContext.setProperty(Constants.GSI_TRANSPORT,
                                       Constants.ENCRYPTION);
            } else if (context.getIntegState()) {
                msgContext.setProperty(Constants.GSI_TRANSPORT,
                                       Constants.SIGNATURE);
            } else {
                msgContext.setProperty(Constants.GSI_TRANSPORT,
                                       Constants.NONE);
            }

            if (context instanceof ExtendedGSSContext) {
                ExtendedGSSContext extGss = (ExtendedGSSContext) context;
                X509Certificate[] certs = null;
                try {
                    certs = (X509Certificate[]) extGss
                        .inquireByOid(GSSConstants.X509_CERT_CHAIN);
                } catch (GSSException e) {
                    // this should never really happen
                    logger.error(i18n.getMessage("general"), e);
                }
                if (certs != null) {
                    subject.getPublicCredentials().add(certs);
                }
            }
        }

        logger.debug("Exit: invoke");
    }

    private Subject getSubject(MessageContext msgContext) {
        Subject subject =
            (Subject) msgContext.getProperty(Constants.PEER_SUBJECT);

        if (subject == null) {
            subject = new Subject();
            msgContext.setProperty(Constants.PEER_SUBJECT, subject);
        }

        return subject;
    }

}