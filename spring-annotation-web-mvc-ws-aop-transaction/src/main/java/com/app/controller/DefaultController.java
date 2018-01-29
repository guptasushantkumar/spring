package com.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.Student;
import com.app.nosql.HBaseService;
import com.app.service.IService;

@Controller
@RequestMapping("/")
public class DefaultController {

	static Logger log = Logger.getLogger(DefaultController.class.getName());

	@Autowired
	private ApplicationContext _applicationContext;

	@Autowired
	private IService employee;

	@Autowired
	private HBaseService hBaseService;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {

		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/springorm", method = RequestMethod.GET)
	public String springorm(ModelMap model) {

		Student student = (Student) _applicationContext.getBean("student", 10,
				"Ram", "Shukla");
		employee.query("162");
		log.error(student.getFirstname());
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/springjson", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody Student springjson() {

		return new Student(23, "meghna", "Naidu");
	}

	@RequestMapping(value = "/springdata", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody Student springdata() throws Exception {

		hBaseService.run();
		return new Student(23, "hbase", "insert");
	}
}
