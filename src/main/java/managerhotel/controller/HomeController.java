package managerhotel.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managerhotel.DAO.impl.LoginDaoImpl;
import managerhotel.Service.impl.LoginServiceImpl;
import managerhotel.model.Users;

@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("username");
		String action = req.getParameter("action");
		if(action !=null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/login.jsp");
			rd.forward(req, resp);
		}else if(action!=null && action.equals("logout")) {
			
		}else {
			
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
//		LoginServiceImpl log = new LoginServiceImpl();
//		  	Users userlogin = new Users();
//		  	try {
//		  		
//				userlogin = log.getUser(userName);
//				System.out.println(userlogin);
//				if(userlogin.getUserName()!=null) {
//					
//				}else {
//					RequestDispatcher rd = req.getRequestDispatcher("/views/admin/login.jsp");
//					rd.forward(req, resp);
//				}
//		  	}catch (Exception e) {
//		  		System.out.println("loi");
//			}
//			

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
