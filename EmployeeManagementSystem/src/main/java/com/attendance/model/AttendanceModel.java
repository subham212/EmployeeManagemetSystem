package com.attendance.model;

public class AttendanceModel {
    private int employeeId;
    private String status; // e.g., "Present", "Absent", "Half Day"
    
    
    

    public AttendanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	// Constructor
    public AttendanceModel(int employeeId, String status) {
        this.employeeId = employeeId;
        this.status = status;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
