package com.ripbank.serviciiweb;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.db.DBManager;

@Path("delete/{cnp}")
public class DeleteClient {

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteClient(@PathParam("cnp") String cnp) {
		JSONObject jsonObject = new JSONObject();
		Log4J.getLogger().info("Request for delete user with CNP: " + cnp);
		boolean val = DBManager.getInstance().deleteClient(cnp);
		jsonObject.put("Deleted:", val);
		Log4J.getLogger().info("Response for delete user with CNP: " + cnp + " :" + jsonObject.toString());
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
