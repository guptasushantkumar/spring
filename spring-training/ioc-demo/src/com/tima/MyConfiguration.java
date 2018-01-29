package com.tima;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.tima" })
public class MyConfiguration {

	@Bean(name = "a11")
	public Address getAddress() {

		return new Address("akbar road", "dhule", 852852);
	}

	@Bean(name = "a12")
	public Address getAddres() {

		return new Address("birbal road", "durg", 852852);
	}

	@Bean(name = "m11")
	public Manager getManager11() {

		return new Manager(2, "Jagtap", "Yadav", getAddres());
	}
}
