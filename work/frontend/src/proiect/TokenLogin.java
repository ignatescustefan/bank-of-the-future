package proiect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

/**
 * Servlet implementation class TokenLogin
 */
@WebServlet("/TokenLogin")
public class TokenLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TokenLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String cnp = (String) request.getSession().getAttribute("cnp");
			TokenAuth auth = new TokenAuth();
			Response myResponse = auth.getAnswer(cnp);
			System.out.println(myResponse);

			String responseAsString = myResponse.readEntity(String.class);
			JSONObject jsonObject = new JSONObject(responseAsString);		
			System.out.println(responseAsString);

			Boolean result = jsonObject.getBoolean("timeIntervalOk");
			System.out.println(result);

			if(result==true) {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} else {
				response.sendRedirect(request.getContextPath()+"/login/token_fail.jsp");
			}
			
		} catch (Exception e) {
			System.out.println("Eroare in servlet-ul de TokenLogin!");
			response.sendRedirect(request.getContextPath()+"/pages/eroare.jsp");
		}
	}

}
