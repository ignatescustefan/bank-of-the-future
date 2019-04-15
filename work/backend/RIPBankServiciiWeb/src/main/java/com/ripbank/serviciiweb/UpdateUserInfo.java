package com.ripbank.serviciiweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.core.DTO.ClientInfoDTO;
import com.ripbank.db.DBManager;

@Path("update")
public class UpdateUserInfo {
	@Path("userInfo/{cnp}")
	@PATCH
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response updateUserInfo(@PathParam("cnp") String cnp,
				ClientInfoDTO clientInfo) {
		JSONObject jsonObject = new JSONObject();
		
		if (DBManager.getInstance().updateUserInformation(cnp, clientInfo.getNume(), clientInfo.getPrenume(), 
				clientInfo.getTelefon())) {
			jsonObject.put("UpdateUserInfo", 1);
			return Response
					.status(200)
					.entity(jsonObject.toString())
					.build();			
		};
		jsonObject.put("UpdateUserInfo", 0);
		return Response
				.status(304)
				.entity(jsonObject)
				.build();
	}
}