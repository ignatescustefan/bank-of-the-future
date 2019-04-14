package com.RIPBankDesktop;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class ClientSearch {

	static String cnp;
	public ClientSearch(String cnp) {
		ClientSearch.cnp=cnp;
	}	
	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/clients/";

	private Client client = ClientBuilder.newClient();

	public Response createJsonClient(String cnp) {
		return client
				.target(REST_URI+cnp)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(cnp, MediaType.APPLICATION_JSON));
	}
}
