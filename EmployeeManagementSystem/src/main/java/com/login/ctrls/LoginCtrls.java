package com.login.ctrls;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.LoginDao;
import com.login.model.LoginModel;


/**
 * Servlet implementation class LoginCtrls
 */
@WebServlet("/login")
public class LoginCtrls extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginModel emp = new LoginModel();
		emp.setUsername(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		LoginDao Dao = new LoginDao();
		if("admin".equals(emp.getUsername()) && "123".equals(emp.getPassword())){
			
			response.sendRedirect("home.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
				 {
			}
		}
	}

}
