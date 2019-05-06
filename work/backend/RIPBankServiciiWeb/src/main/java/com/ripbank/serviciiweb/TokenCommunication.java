package com.ripbank.serviciiweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.db.DBManager;

@Path("token")
public class TokenCommunication {
	@Path("updatePIN")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sendPINToToken(@FormParam("cnp") String cnp) {
		Log4J.getLogger().info("Sending updated PIN to token for CNP: " + cnp);
		// TODO: connect to db and retrieve first PIN
		JSONObject jsonObject = new JSONObject().put("Connected", 1234);
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("authCode/{cnp}")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response receiveAuthCodeFromToken(@PathParam("cnp") String cnp, @FormParam("authCode") String authCode) {
		JSONObject jsonObject = new JSONObject().put("Received", DBManager.getInstance().insertAuthCodeInDB(cnp, authCode));
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}