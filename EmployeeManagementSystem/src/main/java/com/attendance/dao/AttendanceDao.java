package com.attendance.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.attendance.model.AttendanceModel;


public class AttendanceDao {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/exp", "root", "KING 123p#");
    }
    
    public boolean markAttendance(AttendanceModel attendance) {
        Connection con = null;
        PreparedStatement st = null;
        boolean flag = false;
        
        try {
            con = AttendanceDao.getConnection();
            con.setAutoCommit(false);
            st = con.prepareStatement("INSERT INTO attendance (employeeId, status) VALUES (?,?)");
            st.setInt(1, attendance.getEmployeeId());
            st.setString(2, attendance.getStatus());
            
            if (st.executeUpdate() == 1) {
                con.commit();
                flag = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                flag = false;
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (con != null)
                    con.close();
                if (st != null)
                    st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return flag;
    }
    
    public boolean updateAttendance(AttendanceModel attendance) {
        Connection con = null;
        PreparedStatement st = null;
        boolean flag = false;
        
        try {
            con = AttendanceDao.getConnection();
            con.setAutoCommit(false);
            st = con.prepareStatement("UPDATE attendance SET employeeId = ? WHERE status = ? ");
            st.setInt(1, attendance.getEmployeeId());
            st.setString(2, attendance.getStatus());
       
            
            
            if (st.executeUpdate() == 1) {
                con.commit();
                flag = true;
            } else {
                con.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                flag = false;
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (con != null)
                    con.close();
                if (st != null)
                    st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return flag;
    }
}