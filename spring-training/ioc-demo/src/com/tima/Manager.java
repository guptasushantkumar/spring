package com.tima;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("m1")
@Lazy
@Scope("prototype")
public class Manager  {

	private int empid;
	private String fname;
	private String lname;
	
	private Address addr;

	public Manager() {
		super();
		System.out.println("Inside default constructor:-> Manager");
	}

	public Manager(int empid, String fname, String lname, Address addr) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.addr = addr;
		System.out.println("Inside param constructor:-> Manager");
	}

	public int getEmpid() {
		return empid;
	}

	//@Value("1")
	public void setEmpid(int empid) {
		System.out.println("Inside method :-> setEmpid ");
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	//@Value("Sushant")
	public void setFname(String fname) {
		System.out.println("Inside method :-> setFname ");
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	//@Value("Gupta")
	public void setLname(String lname) {
		System.out.println("Inside method :-> setLname ");
		this.lname = lname;
	}

	public Address getAddr() {
		return addr;
	}
	
	//@Value("#{a12}")
	public void setAddr(Address addr) {
		System.out.println("Inside method :-> setAddr ");
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Manager [empid=" + empid + ", fname=" + fname + ", lname="
				+ lname + ", addr=" + addr + "]";
	}


}
