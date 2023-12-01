package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import model.User;

//tiếp nhận requset từ phía người dùng
@WebServlet("/UserController")
public class UserControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDao();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		if (session.getAttribute("session_name") == null) {
			response.sendRedirect("login.jsp");
		} 
		else 
		{

			String action = "";
			if (request.getParameter("act") != null) {
				action = request.getParameter("act");
			}
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				try {
					// kiem tra xem co user do trong datachua
					String username = request.getParameter("user_name");
					UserDao userDao = new UserDao();
					User user = userDao.getUserByUserName(username);
					if (user!=null) {
						checkDuplicate(request, response);
					}
					else
					{	
					insertUser(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "delete":
				try {
					deleteUser(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "edit":
				try {
					ShowEditForm(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "update":
				try {
					String username = request.getParameter("user_name");
					UserDao userDao = new UserDao();
					User user = userDao.getUserByUserName(username);
					if (user!=null) {
						checkDuplicate(request, response);
					}
					else {
						
						updateUser(request, response);
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				try {
					listUser(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("user_name");
		String password = request.getParameter("pass_word");
		String ten = request.getParameter("ten_nguoi_dung");
		String sdtString = request.getParameter("sdt");
		User newUser = new User(username, password, ten, sdtString);
		
		userDao.insertUser(newUser);

		response.sendRedirect("UserController");
		

	}

	// delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("user_id"));
		try {
			userDao.deleteUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("UserController");
	}

	// edit
	private void ShowEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("user_id"));

		User existingUser;
		try {
			existingUser = userDao.selectUser(id);

			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// update
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("user_id"));

		String username = request.getParameter("user_name");
		String password = request.getParameter("pass_word");
		String ten = request.getParameter("ten_nguoi_dung");
		String sdtString = request.getParameter("sdt");

		User user = new User(id, username, password, ten, sdtString);

		if (userDao.updateUser(user)) {
			System.out.println("sua thanh cong");

		} else {
			System.out.println("sua khong thanh cong");
		}
		response.sendRedirect("UserController");
	}

	// default

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		try {
			List<User> listUsers = userDao.selectAllUsers();
			request.setAttribute("listUser", listUsers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	private void checkDuplicate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		
		printWriter.print("<h2 style='color:red; text-align:center'>Username already exists!</h2>");
		// tra ve danh sach user;
		List<User> listUsers = userDao.selectAllUsers();
		request.setAttribute("listUser", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		try {
			dispatcher.include(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
