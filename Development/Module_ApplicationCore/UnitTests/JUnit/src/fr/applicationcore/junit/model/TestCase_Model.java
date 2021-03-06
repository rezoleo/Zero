package fr.applicationcore.junit.model;

/*
 * Copyright 2015-2017 Emmanuel ZIDEL-CAUFFET
 *
 * This class is used in a project designed by some Ecole Centrale de Lille students.
 * This program is distributed in the hope that it will be useful.
 *
 * It is a free code: you can redistribute it and/or modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation, either Version 3 of the License.
 *
 * However the source code is distributed without any warranty
 * See the GNU General Public License for more details.
 *
 */


import fr.applicationcore.Common;
import fr.applicationcore.error.Error;
import fr.applicationcore.error.ErrorMessage;
import fr.applicationcore.junit.network.GateClient;
import fr.applicationcore.junit.network.LoginClient;
import fr.applicationcore.junit.network.ObjectDBClient;
import fr.applicationcore.junit.network.RolesClient;
import fr.core.network.HttpCommunication;

/**
 * Super class which will be extended by the different JUnit test cases
 * @author Zidmann (Emmanuel ZIDEL-CAUFFET)
 * @version 1.1.0
 */
public class TestCase_Model extends fr.junittemplate.test.TestCase_Application_Model
{ 
	protected ObjectDBClient ws_objectdb_client = new ObjectDBClient();
	protected GateClient 	 gate_client 		= new GateClient();
	protected LoginClient 	 login_client 		= new LoginClient();
	protected RolesClient 	 role_client 		= new RolesClient();

	protected String application = "Applicationcore_Testing";
	protected String version     = "1.0.0";

	protected String keyStorePath  	  = "/opt/centrale-datacore/Development/Module_ApplicationCore/UnitTests/NodeJS/certificates/keystore.jks";
	protected String keyStorePassword = "password";

	/**
	 * Check if the error message has the expected properties
	 * @param err Error object
	 * @param msg Message expected in the error object
	 */
	protected void checkBasicMessage(Error err, ErrorMessage msg){
		msg.setStatus(404);
		super.checkMessage(null, null, err, msg);
	}
	/**
	 * Check if the error message has the expected properties
	 * @param err Error object
	 * @param msg Message expected in the error object
	 */
	protected void checkMessage(Error err, ErrorMessage msg){
		super.checkMessage(application, version, err, msg);
	}

	/**
	 * Prepare the environment before a test
	 * @throws Exception Exception returned by the system
	 */
	protected void initSettings() throws Exception{
		ws_objectdb_client.setURL(Common.URL);
		ws_objectdb_client.setProxyParameters(Common.ProxyAdress, Common.ProxyPort);
		ws_objectdb_client.setKeystoreParameters(keyStorePath, keyStorePassword);

		gate_client.setURL(Common.URL);
		gate_client.setProxyParameters(Common.ProxyAdress, Common.ProxyPort);
		gate_client.setKeystoreParameters(keyStorePath, keyStorePassword);

		login_client.setURL(Common.URL);
		login_client.setProxyParameters(Common.ProxyAdress, Common.ProxyPort);
		login_client.setKeystoreParameters(keyStorePath, keyStorePassword);

		role_client.setURL(Common.URL);
		role_client.setProxyParameters(Common.ProxyAdress, Common.ProxyPort);
		role_client.setKeystoreParameters(keyStorePath, keyStorePassword);		

		//Reset the traces used for flood protection
		HttpCommunication.getInstance().sendGet(Common.URL+"/api/floodtest/reset");
	}
}