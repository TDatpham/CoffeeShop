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

import dao.LoaiDao;
import model.Loai;

@WebServlet("/LoaiController")
public class LoaiController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoaiDao loaiDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		loaiDao = new LoaiDao();

	}

	private void showNewFormLoai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loai-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertLoai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String ten_loai = request.getParameter("ten_loai");

		Loai newLoaiUser = new Loai(ten_loai);
		Loai loai = loaiDao.getLoaiByTenLoai(ten_loai);
		if (loai!=null) {
			try {
				checkDuplicate(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
		loaiDao.insertLoai(newLoaiUser);
		response.sendRedirect("LoaiController");
		}
	}

	// delete user
	private void deleteLoai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int loai_id = Integer.parseInt(request.getParameter("loai_id"));
		try {

			loaiDao.deleteLoai(loai_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		response.sendRedirect("LoaiController");
	}

	// edit
	private void ShowEditFormLoai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		int loai_id = Integer.parseInt(request.getParameter("loai_id"));

		Loai existingLoai;
		try {

			existingLoai = loaiDao.selectLoai(loai_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loai-form.jsp");
			request.setAttribute("loai", existingLoai);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// update
	private void updateLoai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int loai_id = Integer.parseInt(request.getParameter("loai_id"));

		String ten_loai = request.getParameter("ten_loai");
		
		Loai loai1 = loaiDao.getLoaiByTenLoai(ten_loai);
		if (loai1!=null) {
			try {
				checkDuplicate(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Loai loai = new Loai(loai_id, ten_loai);
			if (loaiDao.updateLoai(loai)) {
				System.out.println("sua thanh cong");

			} else {
				System.out.println("sua khong thanh cong");
			}
			response.sendRedirect("LoaiController");
		}
		

	}

	// default

	private void listLoai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub

		try {

			List<Loai> listLoais = loaiDao.selectAllLoai();
			request.setAttribute("listLoai", listLoais);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/loai-list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();

		if (session.getAttribute("session_name") == null) {
			resp.sendRedirect("login.jsp");
		} else {

			String action = "";
			if (req.getParameter("act") != null) {
				action = req.getParameter("act");
			}
			switch (action) {
			case "new":

				showNewFormLoai(req, resp);
				break;
			case "insert":
				try {

					insertLoai(req, resp);
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

					deleteLoai(req, resp);
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
					ShowEditFormLoai(req, resp);
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
					updateLoai(req, resp);
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
					listLoai(req, resp);
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	private void checkDuplicate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		
		printWriter.print("<h2 style='color:red; text-align:center'>TenLoai already exists!</h2>");
		
		// danh sach loai
		List<Loai> listLoais = loaiDao.selectAllLoai();
		request.setAttribute("listLoai", listLoais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/loai-list.jsp");
		dispatcher.include(request, response);
	}
	
	
	
	

}