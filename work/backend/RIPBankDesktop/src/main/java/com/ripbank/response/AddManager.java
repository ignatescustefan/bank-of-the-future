package com.ripbank.response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ripbank.core.User;



public class AddManager {
	
	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/addClient";

	private Client client = ClientBuilder.newClient();
	
	public Response createJsonClient(User user) {
	    return client
	      .target(REST_URI)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(user, MediaType.APPLICATION_JSON));
	}
}
