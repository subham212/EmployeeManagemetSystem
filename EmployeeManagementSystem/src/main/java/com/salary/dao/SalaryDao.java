package com.salary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.salary.Model.SalaryModel;


public class SalaryDao {   
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	String DB_URL = "jdbc:mysql://localhost:3306/exp";
        String DB_USER = "root";
        String DB_PASSWORD = "KING 123p#";
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public boolean addSalary(SalaryModel sal) throws ClassNotFoundException {
        boolean flag = false;
        String sqlInsert = "INSERT INTO employee_salary (employee_id, employee_name, basic_salary, hra, da, wd, ma, bonus, pf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection con =null;
        PreparedStatement st=null;
        try { con = SalaryDao.getConnection();
             st = con.prepareStatement(sqlInsert);

            con.setAutoCommit(false);

            st.setString(1, sal.getEmployeeId()); 
            st.setString(2, sal.getEmployeeName());                          
            st.setDouble(3, sal.getHra());          //House Rent Allowance
            st.setDouble(4, sal.getDa());           //Dearness Allowance
            st.setDouble(5, sal.getWd());           //Working Days
            st.setDouble(6, sal.getMa());           //Medical Allowance
            st.setDouble(7, sal.getBonus());
            st.setDouble(8, sal.getPf());           //Provident Fund
            st.setDouble(9, sal.getBasicSalary());
            int value = st.executeUpdate();
            if (value == 1) {
                con.commit();
                flag = true;
            } else {
                con.rollback();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag=false;
        }finally {
        	try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return flag;
    }
    public SalaryModel edit(String empid,String name) {
    	SalaryModel edit= new SalaryModel();
    	Connection con=null;
    	PreparedStatement st=null;    	
    	String query="SELECT employee_id,employee_name,basic_salary,hra,da,wd,ma,bonus,pf FROM employee_salary where employee_id= ?  and employee_name= ?;";
    	try {
    		con=SalaryDao.getConnection();
    		st=con.prepareStatement(query);
    		st.setString(1, empid);
    		System.out.println("in dao : "+empid);
    		System.out.println("in dao : "+ name);
    		st.setString(2, name);
    		ResultSet rs = st.executeQuery();
    		while (rs.next()) {
				edit.setEmployeeName(rs.getString("employee_name"));
				edit.setEmployeeId(rs.getString("employee_id"));
				edit.setHra(rs.getDouble("hra"));
				edit.setDa(rs.getDouble("da"));
				edit.setWd(rs.getDouble("wd"));
				edit.setMa(rs.getDouble("ma"));
				edit.setBonus(rs.getDouble("bonus"));
				edit.setPf(rs.getDouble("pf"));
				edit.setBasicSalary(rs.getDouble("basic_salary"));
				
				System.out.println("in dao File--------------");
				System.out.println(edit.getEmployeeName());
				System.out.println(edit.getEmployeeId());
				System.out.println(edit.getHra());
				System.out.println(edit.getDa());
				System.out.println(edit.getWd());
				System.out.println(edit.getMa());
				System.out.println(edit.getBonus());
				System.out.println(edit.getPf());
				System.out.println(edit.getBasicSalary());
				System.out.println("------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return edit;
    }
    
    public boolean updateSalary(SalaryModel sal ,String empId,String name) {
    	boolean flag=false;
    	String query="UPDATE employee_salary SET employee_id = ?, employee_name = ?, basic_salary = ?, hra = ?, da = ?, wd = ?, ma = ?, bonus = ?, pf = ? WHERE employee_id = ? AND employee_name=?;";
    	Connection con =null;
        PreparedStatement st=null;
        try { con = SalaryDao.getConnection();
        	con.setAutoCommit(false);
        	st=con.prepareStatement(query);
	        st.setString(1, sal.getEmployeeId()); 
	        st.setString(2, sal.getEmployeeName());                          
	        st.setDouble(3, sal.getBasicSalary());
	        st.setDouble(4, sal.getHra());
	        st.setDouble(5, sal.getDa());
	        st.setDouble(6, sal.getWd());
	        st.setDouble(7, sal.getMa());
	        st.setDouble(8, sal.getBonus());
	        st.setDouble(9, sal.getPf());
	        st.setString(10,empId);
	        st.setString(11, name);
	        int value = st.executeUpdate();
	        if (value == 1) {
	            con.commit();
	            flag = true;
	        } else {
	            con.rollback();
	            
	        }
        }catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return flag;
    }

}
