package Employee.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Employee.Employee;
import Employee.Dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeCtrls
 */
@WebServlet("/employee")
public class EmployeeCtrls extends HttpServlet {
	private EmployeeDAO employeeDAO;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	        
    	        if ("view".equals(action)) {
    	            try {
    					viewEmployees(request,response);
    				} catch (ClassNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    	        } else if ("detail".equals(action)) {
    	                            try {
    						showEmployeeDetail(request,response);
    					} catch (NumberFormatException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					} catch (ClassNotFoundException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    	            }
    		}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addEmployee(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        // Retrieve form data
        String fullName = request.getParameter("fullname");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String dateOfJoining = request.getParameter("date-of-joining");
        String employmentType = request.getParameter("employment-type");
        String bankName = request.getParameter("bank-name");
        long accountNumber = Long.parseLong(request.getParameter("account-number"));
        String emergencyName = request.getParameter("emergency-name");
        String emergencyPhone = request.getParameter("emergency-phone");
        String emergencyRelationship = request.getParameter("relationship");

        // Create Employee object
        Employee employee = new Employee();
        employee.setFullName(fullName);
        employee.setDob(dob);
        employee.setGender(gender);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setPosition(position);
        employee.setDateOfJoining(dateOfJoining);
        employee.setEmploymentType(employmentType);
        employee.setBankName(bankName);
        employee.setAccountNumber(accountNumber);
        employee.setEmergencyContactName(emergencyName);
        employee.setEmergencyContactPhone(emergencyPhone);
        employee.setEmergencyContactRelationship(emergencyRelationship);

        // Save employee using DAO
        boolean isSaved = employeeDAO.saveEmployee(employee);

        if (isSaved) {
            response.sendRedirect("EmployeeSuccess.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

	private void viewEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
	    List<Employee> employees = employeeDAO.getAllEmployees();
	    if (employees != null && !employees.isEmpty()) {
	        request.setAttribute("employees", employees); // Set the list of employees
	        request.getRequestDispatcher("employeesList.jsp").forward(request, response); // Forward to list JSP
	    } else {
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}


    private void showEmployeeDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Employee employee = employeeDAO.getEmployeeById(id); // Ensure DAO returns the correct model
        
        if (employee != null) {
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("ViewEmployee.jsp").forward(request, response); // Use a dedicated JSP
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}