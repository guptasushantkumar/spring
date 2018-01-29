package com.tima;

public class Employee {

	private int empId;
	
	private String fname;
	
	private String lname;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String fname, String lname) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int id) {
		this.empId = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fname=" + fname + ", lname=" + lname
				+ "]";
	}
	
	
}
