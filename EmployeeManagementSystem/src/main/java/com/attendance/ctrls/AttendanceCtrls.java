package com.attendance.ctrls;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.attendance.dao.AttendanceDao;
import com.attendance.model.AttendanceModel;

/**
 * Servlet implementation class AttendanceCtrl
 */
@WebServlet("/markAttendance")
public class AttendanceCtrls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceCtrls() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String status = request.getParameter("status");
        

        AttendanceModel attendance = new AttendanceModel(employeeId, status);

        AttendanceDao attendanceDAO = new AttendanceDao();
        boolean success = attendanceDAO.markAttendance(attendance);

        if (success) {
            response.sendRedirect("dashboard.jsp?message=Attendance marked successfully");
        } else {
            response.sendRedirect("dashboard.jsp?message=Failed to mark attendance");
        }

	}

}
