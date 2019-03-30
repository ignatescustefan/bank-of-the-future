package com.ripbank.serviciiweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ripbank.db.DBManager;

@Path("updatePIN")
public class TokenCommunication {

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendPINToToken(@FormParam("cnp") String cnp) {
		// TODO: connect to db, decrypt, see if it's time-valid
		System.out.println(cnp + "  primit ");
		return "Conectat1234";
	}

	@Path("authCode/{cnp}")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public String receiveAuthCodeFromToken(
			@PathParam("cnp") String cnp,
			@FormParam("authCode") String authCode
			) {
		//TODO: connect to db, insert 
		DBManager.getInstance().insertAuthCodeInDB(cnp, authCode);
		return "primit";
	}
}
