package com.tima;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class EmployeeController {

	@Autowired
	private Iservice service;

	@RequestMapping(method = RequestMethod.GET, value = "/saveemp.htm")
	public String showEmpForm(Map<String, Employee> map) {

		System.out.println("Inside showEmpForm");
		map.put("emp", new Employee());
		return "empform";
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST) public String
	 * saveEmployee(@RequestParam("empid") int id, String fname, String lname,
	 * Map map) {
	 * 
	 * System.out.println("Inside saveEmployee"); System.out.println("id: " +
	 * id); System.out.println("fname: " + fname); System.out.println("lname: "
	 * + lname); Employee e = new Employee(id, fname, lname);
	 * System.out.println(e); map.put("emp", e); return "saveemp"; }
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("emp") Employee e,
			BindingResult result) {

		System.out.println("Inside saveEmployee");

		EmployeeValidator empval = new EmployeeValidator();
		empval.validate(e, result);

		if (!result.hasErrors()) {
			System.out.println(e);
			service.insertEmployee(e);
			return "saveemp";
		} else {
			System.out.println("No execution");
			return "empform";
		}
	}

	@RequestMapping("/changelocale.htm")
	public String changeLocale(@RequestParam String lang,
			HttpServletRequest req, Map map) {

		req.getSession().setAttribute(
				SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
				new Locale(lang));

		map.put("emp", new Employee());

		return "redirect:saveemp.htm";
	}
}
