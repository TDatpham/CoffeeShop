package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.LoaiDao;
import dao.ThucDonDao;
import model.Loai;
import model.ThucDon;

@MultipartConfig
@WebServlet("/ThucDonController")
public class ThucDonController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ThucDonDao thucDonDao;
	private LoaiDao loaiDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		thucDonDao = new ThucDonDao();
		loaiDao = new LoaiDao();
	}

	private void showNewFormThucDon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Loai> listLoais = loaiDao.selectAllLoai();
		System.out.println("co lay danh sach loai nha");
		request.setAttribute("listLoai1", listLoais);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/thucdon-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertThucDon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// TODO Auto-generated method stub

		String ten_mon = request.getParameter("ten_mon");
		float don_gia = Float.parseFloat(request.getParameter("don_gia"));
		int loai_id = Integer.parseInt(request.getParameter("loai_id"));
		String images = "";
		
		
		ThucDon thucDon = thucDonDao.getThucDonByTenMon(ten_mon);
		if (thucDon!= null) {
			
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
			
			try {

				Part part = request.getPart("images");
				String realPath = request.getServletContext().getRealPath("/Photos");
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
					System.out.println("co luu duoc file");
				}

				part.write(realPath + "/" + filename);

				images = filename;
				// printWriter.print("<img src='Photos/"+ filename + "'>");

			} catch (Exception e) {
				// TODO: handle exception
			}

			ThucDon newthucdon = new ThucDon(ten_mon, images, don_gia, loai_id);
			thucDonDao.insertThucDon(newthucdon);

			response.sendRedirect("ThucDonController");
		}
		///

		///
	}

	// delete thucdon
	private void deleteThucDon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// TODO Auto-generated method stub
		int thucdon_id = Integer.parseInt(request.getParameter("thucdon_id"));
		try {

			thucDonDao.deleteThucDon(thucdon_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		response.sendRedirect("ThucDonController");
	}

	// edit
	private void ShowEditFormThucDon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		List<Loai> listLoais = loaiDao.selectAllLoai();
		System.out.println("co lay danh sach loai nha");
		request.setAttribute("listLoai1", listLoais);
		int thucdon_id = Integer.parseInt(request.getParameter("thucdon_id"));

		ThucDon existingThucDon;
		try {

			existingThucDon = thucDonDao.selectThucDon(thucdon_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/thucdon-form.jsp");
			request.setAttribute("thucdon", existingThucDon);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// update thuc don
	private void updateThucDon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// TODO Auto-generated method stub
		int thucdon_id = Integer.parseInt(request.getParameter("thucdon_id"));
		String ten_mon = request.getParameter("ten_mon");
		String images = "";
		float don_gia = Float.parseFloat(request.getParameter("don_gia"));
		int loai_id = Integer.parseInt(request.getParameter("loai_id"));
		
		
		ThucDon thucDon = thucDonDao.getThucDonByTenMon(ten_mon);
		if (thucDon!=null) {
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
			try {

				Part part = request.getPart("images");
				String realPath = request.getServletContext().getRealPath("/Photos");
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
					System.out.println("co luu duoc file");
				}

				part.write(realPath + "/" + filename);

				images = filename;
				// printWriter.print("<img src='Photos/"+ filename + "'>");

			} catch (Exception e) {
				// TODO: handle exception
			}

			ThucDon newthucDon = new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id);
			if (thucDonDao.updateThucDon(newthucDon)) {
				System.out.println("sua thanh cong");

			} else {
				System.out.println("sua khong thanh cong");
			}
			response.sendRedirect("ThucDonController");
		}
		
		///

		///
	}

	private void listThucDon(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// TODO Auto-generated method stub

		try {

			List<ThucDon> listThucDons = thucDonDao.selectAllThucDon();
			request.setAttribute("listthucdon", listThucDons);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/thucdon-list.jsp");
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
		} 
		else 
		{
			String action = "";
			if (req.getParameter("act") != null) {
				action = req.getParameter("act");
			}
			switch (action) {
			case "new":

				showNewFormThucDon(req, resp);

				break;
			case "insert":
				try {

					insertThucDon(req, resp);
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

					deleteThucDon(req, resp);
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
					ShowEditFormThucDon(req, resp);
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
					updateThucDon(req, resp);
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
					listThucDon(req, resp);
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
	
	private void checkDuplicate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		
		printWriter.print("<h2 style='color:red; text-align:center'>Food Name already exists!</h2>");
		// tra ve danh sach thuc don
		List<ThucDon> listThucDons = thucDonDao.selectAllThucDon();
		request.setAttribute("listthucdon", listThucDons);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/thucdon-list.jsp");
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
