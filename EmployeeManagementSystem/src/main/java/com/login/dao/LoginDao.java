package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.login.model.LoginModel;


public class LoginDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/exp","root","KING 123p#");
	}
	
	public boolean login(LoginModel emp) {
		Connection con=null;
		PreparedStatement st =null;
		boolean flag =false;
		
		
		try {
			con =LoginDao.getConnection();
			con.setAutoCommit(false);
			st=con.prepareStatement("INSERT INTO users (username , password) VALUES (?,?)");
			st.setString(1,emp.getUsername());
			st.setString(2, emp.getPassword());
			if(st.executeUpdate() == 1 ) {
				con.commit();
				flag=true;
			}else {
				con.rollback();
			}
					
		}catch (Exception e) {
			e.printStackTrace();
			try {
				flag = false;
				con.rollback();
				
			}catch (SQLException e1) {
				e1.printStackTrace();
			}			
		}finally {
			try {
				if (con != null)
					con.close();
				if(st != null)
					st.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
}
