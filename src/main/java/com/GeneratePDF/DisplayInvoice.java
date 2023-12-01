package com.GeneratePDF;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/DisplayInvoice")
public class DisplayInvoice  extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionuser = req.getSession();
		
		Object object = sessionuser.getAttribute("session_user");
		if(object != null)
		{
		User user = (User) object;
		int user_id = user.getUser_id();
		
		
		CreatePDF createPDF = new CreatePDF();
		createPDF.generatePDF(user_id);
		
		
		
		
		File file = new File("D:\\Final_of_term_Java\\hoadon\\hoadon.pdf");
		 //check if file exists  then open otherwise not
		if (file.exists()) {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(file);
			}
			else {
				System.err.println("Not Supported");
			}
			
		}
		else {
			System.err.println("File not exists");
		}
		
		resp.sendRedirect(req.getContextPath()+"/NewOrder");
		
		}
		else {
			resp.sendRedirect("loginUser.jsp");
		}
	}
	
}
