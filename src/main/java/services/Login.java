package services;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;


@WebServlet("/Loginform")
public class Login extends HttpServlet 
{  	
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao;
	
	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		adminDao = new AdminDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		String username = req.getParameter("user_name");
		String password = req.getParameter("pass_word");
		
		if (adminDao.checkAdmin(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("session_name", username);
			
			resp.sendRedirect("home.jsp");
			
		}
		else {
			printWriter.println("<h3 style='color:red; padding-left:9%;'> Username and password didn't match</h3>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
			requestDispatcher.include(req, resp);
			
			
		}
		
		
		
	}
	
}
