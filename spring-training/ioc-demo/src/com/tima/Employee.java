package com.tima;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Employee implements BeanNameAware, ApplicationContextAware,
		InitializingBean, DisposableBean {

	private int empid;
	private String fname;
	private String lname;
	private Address addr;

	public Employee() {
		super();
		System.out.println("Inside default constructor:-> Employee");
	}

	public Employee(int empid, String fname, String lname, Address addr) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.addr = addr;
		System.out.println("Inside param constructor:-> Employee");
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		System.out.println("Inside method :-> setEmpid ");
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		System.out.println("Inside method :-> setFname ");
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		System.out.println("Inside method :-> setLname ");
		this.lname = lname;
	}

	public Address getAddr() {
		return addr;
	}
	
	//@Autowired
	@Resource(name="a1")
	@Required
	public void setAddr(Address addr) {
		System.out.println("Inside method :-> setAddr ");
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", lname="
				+ lname + ", addr=" + addr + "]";
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Inside method :-> setBeanName " + arg0);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("Inside method :-> setApplicationContext " + arg0);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside method :-> afterPropertiesSet ");

	}
		
	public void doInit() {
		System.out.println("Inside method :-> doInit ");

	}
	
	public void doDestroy() {
		System.out.println("Inside method :-> doDestroy ");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside method :-> destroy ");
		
	}

}
