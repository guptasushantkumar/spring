package com.tima;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("a0")
@Lazy
@Scope("prototype")
public class Address {
	
	private String street;
	private String city;
	private int zip;
	
	public Address() {
		super();
		System.out.println("Inside constructor:-> Address");
	}
	
	public Address(String street, String city, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		System.out.println("Inside param constructor:-> Address");
	}

	public String getStreet() {
		return street;
	}

	//@Value("mumtaz road")
	public void setStreet(String street) {
		System.out.println("Inside method :-> setStreet ");
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	//@Value("Hyderabad")
	public void setCity(String city) {
		System.out.println("Inside method :-> setCity ");
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	//@Value("963852")
	public void setZip(int zip) {
		System.out.println("Inside method :-> setZip ");
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zip=" + zip
				+ "]";
	}
	
	

}
