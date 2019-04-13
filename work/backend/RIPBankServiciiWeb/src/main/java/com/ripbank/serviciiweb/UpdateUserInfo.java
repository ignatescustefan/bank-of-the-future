package com.ripbank.serviciiweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.ripbank.core.DTO.ClientInfoDTO;
import com.ripbank.db.DBManager;

@Path("update")
public class UpdateUserInfo {
	@Path("userInfo/{cnp}")
	@PATCH
	@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON})
	public Response sendPINToToken(@PathParam("cnp") String cnp,
			ClientInfoDTO clientInfo) {
		if (DBManager.getInstance().updateUserInformation(cnp, clientInfo.getNume(), clientInfo.getPrenume(), 
				clientInfo.getTelefon())) {
			return Response
					.status(200)
					.build();			
		};
		return Response
				.status(304)
				.build();
	}
}
