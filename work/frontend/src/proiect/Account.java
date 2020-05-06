package proiect;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Account {
	
	static String cnp;
	public Account(String cnp) {
		Account.cnp=cnp;
	}	
		
	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/accounts/";

	private Client client = ClientBuilder.newClient();
	
	public Response extractAccountInformation() {
	    return client
	      .target(REST_URI+cnp)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(cnp, MediaType.APPLICATION_JSON));
	}
}
