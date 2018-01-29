package com.javatpoint;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController implements ApplicationContextAware {

	ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(
			final ApplicationContext applicationContext) throws BeansException {
		System.out.println("setting context");
		this.applicationContext = applicationContext;
	}

	@RequestMapping("test")
	public void doSomething() {
		if (applicationContext != null && applicationContext.containsBean("e")) {
			Employee s = (Employee) applicationContext.getBean("e");
			s.show();
		}

	}

}
