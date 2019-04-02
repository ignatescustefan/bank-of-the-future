package proiect;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class SendData {
	
	private static String cnp;
	public SendData(String cnp) {
		SendData.cnp=cnp;
	}	

	private static final String REST_URI = "http://localhost:8080/RIPBankServiciiWeb/api/update/userInfo/";

	private Client client = ClientBuilder.newClient();
	
//	public Response sendJsonDate(JSONObject json) {
//	    return client
//	      .target(REST_URI+cnp)
//	      .request(MediaType.APPLICATION_JSON)
//	      .post(Entity.entity(json, MediaType.APPLICATION_JSON));
//	}
	
	public Response sendFormAppl(String string) {
		return client
			      .target(REST_URI+cnp)
			      .request(MediaType.APPLICATION_JSON)
			      .post(Entity.entity(string, MediaType.TEXT_PLAIN)); 
	}
}
