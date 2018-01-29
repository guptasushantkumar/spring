package com.tima;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET, value = "/hello.htm")
	public String sayHello1() {

		System.out.println("sayHello1");
		return "hello";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/abc.htm")
	public String sayHello2(Model model) {
		System.out.println("sayHello2");
		model.addAttribute("msg", "Welcome to spring mvc 2");
		return "hello";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/pqr.htm")
	public String sayHello3(Map<String, String> map) {
		System.out.println("sayHello3");
		map.put("msg", "Welcome to spring mvc 3");
		return "hello";
	}
}
