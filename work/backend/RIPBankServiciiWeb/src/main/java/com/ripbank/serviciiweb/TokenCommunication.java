package com.ripbank.serviciiweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.logging.Log4J;
import com.ripbank.db.DBManager;

//TODO: need to review this
@Path("token")
public class TokenCommunication {
	@Path("updatePIN")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String sendUpdatedPINToToken(@FormParam("cnp") String cnp) {
		Log4J.getLogger().info("Request PIN update from CNP: " + cnp);
		String pin = DBManager.getInstance().getPINForUserCNP(cnp);
		Log4J.getLogger().info("Response for request PIN update from CNP: " + cnp +": "+pin);
		return "Conectat" + pin;
	}

	@Path("authCode/{cnp}")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public String receiveAuthCodeFromToken(@PathParam("cnp") String cnp, @FormParam("authCode") String authCode) {
		Log4J.getLogger().info("Receive authCode from token for : " + cnp);
		DBManager.getInstance().insertAuthCodeIntoDB(cnp, authCode);
		Log4J.getLogger().info("Received authCode from token for : " + cnp);
		return "primit";
	}
}