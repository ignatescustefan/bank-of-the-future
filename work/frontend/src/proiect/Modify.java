package proiect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 * Servlet implementation class Modify
 */

@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modify() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nume=request.getParameter("nume");
		String prenume=request.getParameter("prenume");
		String telefon=request.getParameter("telefon");

		String cnp=(String) request.getSession().getAttribute("cnp");

		StringBuilder builder=new StringBuilder();
		builder.append("nume="+nume);
		builder.append("&prenume="+prenume);
		builder.append("&telefon="+telefon);

		SendData sd = new SendData(cnp);
		sd.sendFormAppl(builder.toString());
		
		//APASAREA butonului trebuie sa apeleze metoda PATCH, nu post :)
	}
}
