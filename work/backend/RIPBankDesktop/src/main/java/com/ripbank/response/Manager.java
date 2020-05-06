package com.ripbank.response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ripbank.core.EmployeeDTO;



public class Manager {
	
	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/login/employee";

	private Client client = ClientBuilder.newClient();
	
	public Response createJsonAngajat(EmployeeDTO user) {
	    return client
	      .target(REST_URI)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(user, MediaType.APPLICATION_JSON));
	}
}
