package com.tima;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmployeeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		System.out.println("Inside " + this.getClass().getName() + "class");
		String model = "Welcome to spring mvc";
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", model);
		mv.setViewName("hello");
		return mv;
	}

}
