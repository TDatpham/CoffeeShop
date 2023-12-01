package services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Table;

@WebServlet("/ResetTableService")
public class ResetTableService extends HttpServlet {

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
		
		int ban_id = Integer.parseInt(req.getParameter("id_ban"));
		
		HttpSession sessionTable = req.getSession();
		Object obtable = sessionTable.getAttribute("dstable");
		
	
		@SuppressWarnings("unchecked")
		List<Table> tables = (List<Table>) obtable;
		for (Table table : tables) {
			if (table.getBan_id() ==ban_id) {
				table.setStatus(true);
				break;
			}
		}
		
		
		sessionTable.setAttribute("dstable", tables);
		
		resp.sendRedirect("cart.jsp");
		}
		else {
			resp.sendRedirect("loginUser.jsp");
		}
	}
	
}
