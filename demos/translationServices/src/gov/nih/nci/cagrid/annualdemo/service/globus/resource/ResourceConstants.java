/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-general/LICENSE.txt for details.
*============================================================================
**/
package gov.nih.nci.cagrid.annualdemo.service.globus.resource;

import javax.xml.namespace.QName;


public interface ResourceConstants {
	public static final String SERVICE_NS = "http://annualdemo.cagrid.nci.nih.gov/MageTranslationServices";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "MageTranslationServicesKey");
	public static final QName RESOURCE_PROPERY_SET = new QName(SERVICE_NS, "MageTranslationServicesResourceProperties");

	//Service level metadata (exposed as resouce properties)
	
}
