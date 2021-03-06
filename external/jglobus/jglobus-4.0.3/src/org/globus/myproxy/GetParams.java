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
package org.globus.myproxy;

/**
 * Holds the parameters for the <code>get</code> operation.
 */
public class GetParams
    extends Params {

    private String credentialName;

    public GetParams() {
	super(MyProxy.GET_PROXY);
    }

    public GetParams(String username, String passphrase) {
	super(MyProxy.GET_PROXY, username, passphrase);
    }

    public void setCredentialName(String credentialName) {
	this.credentialName = credentialName;
    }

    public String getCredentialName() {
	return this.credentialName;
    }

    protected String makeRequest(boolean includePassword) {
	StringBuffer buf = new StringBuffer();
	buf.append(super.makeRequest(includePassword));
	add(buf, CRED_NAME, credentialName);
	return buf.toString();
    }
    
}
