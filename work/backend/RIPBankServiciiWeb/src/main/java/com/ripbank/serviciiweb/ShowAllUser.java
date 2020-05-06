package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("user")
public class ShowAllUser {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClient() {
		Log4J.getLogger().info("Request for all user account");
		JSONObject json = retriveUser();
		Log4J.getLogger().error("Result for user result: " + json.toString());
		return Response.status(200)
				.entity(json.toString())
				.build();
	}
	static JSONObject retriveUser() {
		List<User> clients = DBManager.getInstance().getAllUser();

		JSONObject json = new JSONObject();
		if (null == clients) {
			json.put("Error", 1);
			Log4J.getLogger().error("Error at getting all users from database:");
		} else {
			for(User usr : clients) {
				JSONObject obj=new JSONObject()
						.put("nume", usr.getNume())
						.put("prenume", usr.getPrenume())
						.put("email", usr.getEmail())
						.put("parola", usr.getParola())
						.put("telefon", usr.getTelefon())
						.put("status", usr.getClientStatus());
				json.append("user", obj);
			}
		}
		Log4J.getLogger().error("Result for  result: " + json.toString());
		return json;
	}
}
