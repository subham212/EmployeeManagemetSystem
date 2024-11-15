package com.salary.ctrls;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.salary.Model.SalaryModel;
import com.salary.dao.SalaryDao;


/**
 * Servlet implementation class UpdateSalaryCtrls
 */
@WebServlet("/updateEmployeeSalary")
public class UpdateSalaryCtrls extends HttpServlet {
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
		String action= request.getParameter("action");
    	System.out.println("in updateCtrl : "+action);
    	String name=request.getParameter("Name");
    	System.out.println("in updateCtrl : "+name);
    	String empId= request.getParameter("empId");
    	System.out.println("in updateCtrl : "+empId);
    	SalaryDao dao = new SalaryDao();
    	switch (action) {
		case "edit":
			SalaryModel addSal = dao.edit(empId, name);			
			request.setAttribute("name", addSal.getEmployeeName());
			request.setAttribute("empid",addSal.getEmployeeId());
			request.setAttribute("hra",addSal.getHra());
			request.setAttribute("da",addSal.getDa());
			request.setAttribute("wd",addSal.getWd());
			request.setAttribute("ma",addSal.getMa());
			request.setAttribute("bonus",addSal.getBonus());
			request.setAttribute("pf",addSal.getPf());
			request.setAttribute("basic_salary",addSal.getBasicSalary());
			request.getRequestDispatcher("UpdateSalary.jsp").forward(request, response);
			break;
			
		case "update":
			SalaryModel sal=new SalaryModel();
			sal.setEmployeeName(request.getParameter("name"));
	        sal.setEmployeeId(request.getParameter("empId"));
	        sal.setHra(Double.parseDouble(request.getParameter("hra")));  
	        sal.setDa(Double.parseDouble(request.getParameter("da")));   
	        sal.setWd(Double.parseDouble(request.getParameter("wd")));    
	        sal.setMa(Double.parseDouble(request.getParameter("ma")));    
	        sal.setBonus(Double.parseDouble(request.getParameter("bonus")));
	        sal.setPf(Double.parseDouble(request.getParameter("pf")));    
	        sal.setBasicSalary(Double.parseDouble(request.getParameter("basicsalary")));
			System.out.println("in dao update.....");
			if (dao.updateSalary(sal , empId,name)) {
				System.out.println(true);
				response.sendRedirect("update.jsp");
			}else {
				System.out.println(false);
			}
			break;

		default:
			break;
		}

	}

}
