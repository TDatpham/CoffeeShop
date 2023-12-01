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

import dao.UserDao;
import model.User;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.checkUser(username, password);
		
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("session_user", user);
			
			resp.sendRedirect(req.getContextPath()+"/HomeService");
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			resp.setContentType("text/html");
			
			printWriter.println("<h3 style='color:red; padding-left:9%;'> Username and password didn't match</h3>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/loginUser.jsp");
			requestDispatcher.include(req, resp);
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("loginUser.jsp");
	}
}
