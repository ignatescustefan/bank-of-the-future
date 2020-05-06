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

@Path("deleteEmployee/{email}")
public class DeleteEmployee {
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteClient(@PathParam("email") String email) {
		JSONObject jsonObject = new JSONObject();
		Log4J.getLogger().info("Request for delete employee with email: " + email);
		boolean val = DBManager.getInstance().deleteEmloyee(email);
		jsonObject.put("Deleted:", val);
		Log4J.getLogger().info("Response for employee with email: " + email + " :" + jsonObject.toString());
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
