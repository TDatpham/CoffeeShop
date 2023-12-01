package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoaiDao;
import dao.ThucDonDao;
import model.Loai;
import model.ThucDon;

@WebServlet("/HomeService")
public class HomeService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		 HttpSession session = req.getSession();
		  
		  //clear 
		 
		if(session.getAttribute("session_user") != null)
		{	
		
		List<ThucDon> thucDons = new ArrayList<>();
		
		ThucDonDao thucDonDao = new ThucDonDao();
		
		thucDons = thucDonDao.getNewThucDons(6);
		
		req.setAttribute("listproduce", thucDons);
	
		
		LoaiDao loaiDao = new LoaiDao();
		List<Loai> listloai = new ArrayList<Loai>();
		listloai =  loaiDao.selectCafeAndTea();
		req.setAttribute("listcafetra", listloai);
		
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/homeuser.jsp");
		requestDispatcher.forward(req, resp);
		}
		else {
			resp.sendRedirect("loginUser.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
