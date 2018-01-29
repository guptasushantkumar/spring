package com.app.config;

import java.util.HashMap;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.app.model.Student;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({ "com.app.controller", "com.app.logging", "com.app.service",
		"com.app.dao" })
public class AppConfiguration {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		HashMap<String, String> test = new HashMap<>();
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	@Scope("prototype")
	// As we want to create several beans with different args, right?
	String hello(String name) {
		return "Hello, " + name;
	}

	@Bean
	@Scope("prototype")
	public Student student(int id, String firstname, String lastname) {
		Student student = new Student(Integer.valueOf(id), firstname, lastname);
		return student;
	}
}
