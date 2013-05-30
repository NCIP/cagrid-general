/*
============================================================================
  Copyright The Ohio State University Research Foundation, The University of Chicago - 
	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
	Ekagra Software Technologies Ltd.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/cagrid-general/LICENSE.txt for details.
============================================================================
*/
# Replace the <<database_name>> with proper database name that is to be created.

USE <<database_name>>;


UPDATE csm_application SET csm_application.DECLARATIVE_FLAG='0';

ALTER TABLE CSM_PROTECTION_ELEMENT DROP COLUMN PROTECTION_ELEMENT_TYPE_ID;
ALTER TABLE CSM_PROTECTION_ELEMENT ADD COLUMN PROTECTION_ELEMENT_TYPE VARCHAR(100);
ALTER TABLE CSM_PG_PE MODIFY COLUMN UPDATE_DATE DATE;
ALTER TABLE CSM_APPLICATION MODIFY COLUMN APPLICATION_NAME VARCHAR(255) NOT NULL;
ALTER TABLE CSM_GROUP MODIFY COLUMN GROUP_NAME VARCHAR(255) NOT NULL;
ALTER TABLE CSM_PROTECTION_ELEMENT ADD UNIQUE UQ_PE_OBJECT_ID_ATTRIBUTE_APP_ID(PROTECTION_ELEMENT_NAME, ATTRIBUTE, APPLICATION_ID);

ALTER TABLE CSM_APPLICATION ADD COLUMN DATABASE_URL VARCHAR(100);
ALTER TABLE CSM_APPLICATION ADD COLUMN DATABASE_USER_NAME VARCHAR(100);
ALTER TABLE CSM_APPLICATION ADD COLUMN DATABASE_PASSWORD VARCHAR(100);
ALTER TABLE CSM_APPLICATION ADD COLUMN DATABASE_DIALECT VARCHAR(100);
ALTER TABLE CSM_APPLICATION ADD COLUMN DATABASE_DRIVER VARCHAR(100);

UPDATE csm_pg_pe SET UPDATE_DATE=NULL;
