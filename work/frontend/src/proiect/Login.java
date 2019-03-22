package proiect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=request.getParameter("user");
		String p=request.getParameter("pass");
		
		//aici redirectare la /api/login cu username=user & pass=pass
		//response.sendRedirect("/RIPBankServiciiWeb/api"+"/login");
		
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("RIPBankServiciiWeb/api"+"/login");
		dispatcher.forward(request, response);
		
		//dispatcher.forward(request, response);
		
		//System.out.println("/RIPBankServiciiWeb/api"+"/login");
		
		//primesc un json 
		//deserializare json
		//setare atribute sesiune
		
		/*
		if(UserDAO.instance().verifica(u, p)) {
			HttpSession s=request.getSession(true);
			s.setAttribute("username",u);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/second_step.jsp");
		}
		*/
	}

}
