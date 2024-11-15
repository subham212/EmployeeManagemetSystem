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



@WebServlet("/empSalary")
public class AddSalaryCtrls extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AddSalary.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalaryModel sal = new SalaryModel();
        sal.setEmployeeName(request.getParameter("name"));
        sal.setEmployeeId(request.getParameter("empId"));
        sal.setHra(Double.parseDouble(request.getParameter("hra")));      
        sal.setDa(Double.parseDouble(request.getParameter("da")));         
        sal.setWd(Double.parseDouble(request.getParameter("wd")));        
        sal.setMa(Double.parseDouble(request.getParameter("ma")));         
        sal.setBonus(Double.parseDouble(request.getParameter("bonus")));    
        sal.setPf(Double.parseDouble(request.getParameter("pf")));        
        sal.setBasicSalary(Double.parseDouble(request.getParameter("basicsalary")));
        
        System.out.println(sal.getEmployeeId());
        System.out.println(sal.getEmployeeName());
        System.out.println(sal.getHra());              
        System.out.println(sal.getDa());               
        System.out.println(sal.getWd());                
        System.out.println(sal.getMa());              
        System.out.println(sal.getBonus());
        System.out.println(sal.getPf());               
        System.out.println(sal.getBasicSalary());
        
        String msg=null;
        
        
        SalaryDao dao = new SalaryDao();
        try {
			if(dao.addSalary(sal))
			{
				msg = "Salary added successfully!"; 
				response.sendRedirect("successfull.jsp");
				System.out.println("succesfully");
			}else {
				msg = "Failed to add salary. Please try again.";
				request.setAttribute("msg",msg);
				System.out.println("failed");
			    request.getRequestDispatcher("AddSalary.jsp").forward(request, response);
			}
			System.out.println(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
        }
}
