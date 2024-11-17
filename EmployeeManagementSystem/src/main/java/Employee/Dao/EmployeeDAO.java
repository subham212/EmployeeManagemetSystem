package Employee.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Employee.Employee;


public class EmployeeDAO {

	 public static Connection getConnection() throws SQLException, ClassNotFoundException {
	        String DB_URL = "jdbc:mysql://localhost:3306/exp";
	        String DB_USER = "root";
	        String DB_PASSWORD = "KING 123p#";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    }

	 public boolean saveEmployee(Employee employee) throws ClassNotFoundException {
		    String query = "INSERT INTO employees (fullName, dob, gender, address, phone, email, position, dateOfJoining, employmentType, bankName, accountNumber, emergencyContactName, emergencyContactPhone, emergencyContactRelationship) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		    try (Connection conn = getConnection();
		         PreparedStatement ps = conn.prepareStatement(query)) {

		        ps.setString(1, employee.getFullName());
		        ps.setString(2, employee.getDob());
		        ps.setString(3, employee.getGender());
		        ps.setString(4, employee.getAddress());
		        ps.setString(5, employee.getPhone()); // Fixed: Add phone to query
		        ps.setString(6, employee.getEmail());
		        ps.setString(7, employee.getPosition());
		        ps.setString(8, employee.getDateOfJoining());
		        ps.setString(9, employee.getEmploymentType());
		        ps.setString(10, employee.getBankName());
		        ps.setLong(11, employee.getAccountNumber());
		        ps.setString(12, employee.getEmergencyContactName());
		        ps.setString(13, employee.getEmergencyContactPhone());
		        ps.setString(14, employee.getEmergencyContactRelationship());

		        int rowsAffected = ps.executeUpdate();
		        return rowsAffected > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}


    public List<Employee> getAllEmployees() throws ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT id, fullName, position FROM employees";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFullName(rs.getString("fullName"));
                employee.setPosition(rs.getString("position"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int id) throws ClassNotFoundException {
        Employee employee = null;
        String query = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFullName(rs.getString("fullName"));
                employee.setDob(rs.getString("dob"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setPosition(rs.getString("position"));
                employee.setDateOfJoining(rs.getString("dateOfJoining"));
                employee.setEmploymentType(rs.getString("employmentType"));
                employee.setBankName(rs.getString("bankName"));
                employee.setAccountNumber(rs.getLong("accountNumber"));
                employee.setEmergencyContactName(rs.getString("emergencyContactName"));
                employee.setEmergencyContactPhone(rs.getString("emergencyContactPhone"));
                employee.setEmergencyContactRelationship(rs.getString("emergencyContactRelationship"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}