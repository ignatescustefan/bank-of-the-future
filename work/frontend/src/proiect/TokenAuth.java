package proiect;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class TokenAuth {
	
	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/login/secondStepAuth";

	private Client client = ClientBuilder.newClient();
	
	public Response getAnswer(String cnp) {
	    return client
	      .target(REST_URI)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(cnp, MediaType.APPLICATION_JSON));
	}
}
