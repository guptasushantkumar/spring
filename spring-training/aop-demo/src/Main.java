import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tima.Employee;
import com.tima.IService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop.xml");

		Employee e1 = new Employee(1, "Sushant", "Gupta");

		//IService objEmpService = context.getBean("empservice", IService.class);
		IService objEmpService = context.getBean("target", IService.class);
		objEmpService.insert(e1);
//		objEmpService.update(e1);
//		objEmpService.remove(e1);

	}

}
