package com.ripbank.serviciiweb;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("updatePIN")
public class PINUpdate {
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendPINToToken(@FormParam("cnp") String cnp) {
		// connect to db, decrypt, see if it's time-valid
		System.out.println(cnp + "  primit ");
		return "Conectat1234";
	}
}