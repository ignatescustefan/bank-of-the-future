package com.ripbank.serviciiweb;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.Employee;
import com.ripbank.core.User;
import com.ripbank.core.DTO.CredentialsDTO;
import com.ripbank.db.DBManager;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("login")
public class Login {

	private JSONObject checkUserEmailAndPass(CredentialsDTO user) {
		List<User> usersList = DBManager.getInstance().findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Log4J.getLogger().info("Attempt to login user with: " + user.toString());
		if (null == usersList || 1 != usersList.size()) {
			Log4J.getLogger().info("Failed login for user: " + user.toString());
			return new JSONObject().put("LoginOk", 0);
		}
		Log4J.getLogger().info("Successfully login user with: " + usersList.get(0).toString());
		return new JSONObject().put("LoginOk", 1).put("CNP", usersList.get(0).getCnp())
				.put("Email", usersList.get(0).getEmail()).put("Nume", usersList.get(0).getNume())
				.put("Prenume", usersList.get(0).getPrenume()).put("Telefon", usersList.get(0).getTelefon());
	}

	private JSONObject checkEmployeeEmailAndPass(CredentialsDTO employee) {
		List<Employee> employees = DBManager.getInstance().findEmployeeByEmailAndPass(employee.getEmail(),
				employee.getPassword());
		Log4J.getLogger().info("Attempt to login employee with: " + employee.toString());
		if (null == employees || 1 != employees.size()) {
			Log4J.getLogger().info("Failed login for employee: " + employee.toString());
			return new JSONObject().put("LoginOk", 0);
		}
		return new JSONObject().put("LoginOk", 1).put("Email", employees.get(0).getEmail())
				.put("Nume", employees.get(0).getNume()).put("Prenume", employees.get(0).getPrenume());
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAuthorizedUser(CredentialsDTO user) {
		JSONObject jsonObject = checkUserEmailAndPass(user);
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("/employee")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAuthorizedEmployee(CredentialsDTO user) {
		JSONObject jsonObject = checkEmployeeEmailAndPass(user);
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	// TODO: need to move verifyTokenAuth to another API
	@Path("/{cnp}")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response verifyTokenAuth(@PathParam("cnp") String cnp) {
		// TODO: get current time; if it's <1 min, return ok
		/*
		 * if it's fine return Response.status(200).build();
		 */
		return Response.status(401).build();

	}
}