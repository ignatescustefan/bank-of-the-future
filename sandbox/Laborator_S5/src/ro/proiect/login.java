package ro.proiect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		if(UserDAO.instance().verifica(u, p)) {
			HttpSession s=request.getSession(true);
			s.setAttribute("username",u);
			response.sendRedirect(request.getContextPath()+"/useri.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

}
