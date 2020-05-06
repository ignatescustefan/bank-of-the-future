package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.User;
import com.ripbank.core.DTO.ClientInfoDTO;
import com.ripbank.db.DBManager;

@Path("update")
public class UpdateUserInfo {
	@Path("userInfo/{cnp}")
	@PATCH
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateUserInfo(@PathParam("cnp") String cnp, ClientInfoDTO clientInfo) {
		JSONObject jsonObject = new JSONObject();
		Log4J.getLogger().info("Request for change information for user: " + clientInfo.toString() + ", CNP: " + cnp);
		if (DBManager.getInstance().updateUserInformation(cnp, clientInfo.getNume(), clientInfo.getPrenume(),
				clientInfo.getTelefon())) {
			List<User> users = DBManager.getInstance().findUserByCNP(cnp);
			if (1 == users.size()) {
				jsonObject.put("UpdateUserInfo", 1);
				for (User user : users) {
					jsonObject.put("Nume", user.getNume()).put("Prenume", user.getPrenume()).put("Telefon",
							user.getTelefon());
				}
				Log4J.getLogger().info("Successfully changed details for user: "+cnp+jsonObject.toString());
				return Response.status(200).entity(jsonObject.toString()).build();
			}
		}
		;
		jsonObject.put("UpdateUserInfo", 0);
		Log4J.getLogger().info("Failed operation of changing details for user: "+cnp+jsonObject.toString());
		return Response.status(304).entity(jsonObject).build();
	}
}