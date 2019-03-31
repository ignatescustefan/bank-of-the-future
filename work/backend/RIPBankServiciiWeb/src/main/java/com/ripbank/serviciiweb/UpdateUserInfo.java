package com.ripbank.serviciiweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ripbank.db.DBManager;

@Path("update")
public class UpdateUserInfo {
	@Path("userInfo/{cnp}")
	@PATCH
	@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON})
	public Response sendPINToToken(
			@PathParam("cnp") String cnp,
			@FormParam("email") String email,
			@FormParam("nume") String nume,
			@FormParam("prenume") String prenume,
			@FormParam("telefon") String telefon
			) {
		DBManager.getInstance().updateUserInformation(cnp, email, nume, prenume, telefon);
		//TODO: get user from DB, create json with updated info
		return Response
				.status(200)
				.build();
	}
}
