package controllers;

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

@WebServlet("/DetailController")
public class DetailController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		  
		  //clear 
		 
		if(session.getAttribute("session_user") == null)
		{
			resp.sendRedirect("loginUser.jsp");
		}
		else {
			
		
		// TODO Auto-generated method stub
		LoaiDao loaiDao = new LoaiDao();
		List<Loai> listloai = new ArrayList<Loai>();
		listloai =  loaiDao.selectCafeAndTea();
		req.setAttribute("listcafetra", listloai);
		
		int thucdon_id = Integer.parseInt(req.getParameter("thucdon_id"));
		
		ThucDonDao thucDonDao = new ThucDonDao();
		ThucDon thucDon = new ThucDon();
		thucDon = thucDonDao.selectThucDon(thucdon_id);
		
		req.setAttribute("thucdon", thucDon);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/detailproduce.jsp");
		requestDispatcher.forward(req, resp);
		}
	}
}
