/**
 * NotificationConsumerFactoryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.globus.wsrf.core.tests.interop.service;

public interface NotificationConsumerFactoryService extends javax.xml.rpc.Service {
    public java.lang.String getNotificationConsumerFactoryPortAddress();

    public org.globus.wsrf.core.tests.interop.NotificationConsumerFactory getNotificationConsumerFactoryPort() throws javax.xml.rpc.ServiceException;

    public org.globus.wsrf.core.tests.interop.NotificationConsumerFactory getNotificationConsumerFactoryPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}