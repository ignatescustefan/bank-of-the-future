package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("clients")
public class SearchClient {
	@GET
	@Path("{cnp}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClient(@PathParam("cnp") String cnp) {
		Log4J.getLogger().info("Request for client with cnp: " + cnp);
		List<User> clients = DBManager.getInstance().findUserByCNP(cnp);
		JSONObject json = new JSONObject();
		if (null == clients || clients.size() > 1) {
			json.put("Error", 1);
			Log4J.getLogger().error("Error at searching client with cnp: " + cnp);
		} else {
			for (User client : clients) {
				json.put("nume", client.getNume()).put("prenume", client.getPrenume()).put("email", client.getEmail())
				.put("parola", client.getParola()).put("telefon", client.getTelefon()).put("status", client.getClientStatus());
			}
		}
		Log4J.getLogger().error("Search result for CNP " + cnp + " result: " + json.toString());
		return Response.status(200).entity(json.toString()).build();
	}
}
