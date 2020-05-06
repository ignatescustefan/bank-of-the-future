package proiect;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DTO.TransactionDTO;

public class SendTransaction {

	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/transaction";

	private Client client = ClientBuilder.newClient();
	
	public Response getAnswer(TransactionDTO transaction) {
	    return client
	      .target(REST_URI)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(transaction, MediaType.APPLICATION_JSON));
	}
}
