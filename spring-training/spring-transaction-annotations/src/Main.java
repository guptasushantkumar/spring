import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tima.Employee;
import com.tima.EmployeeService;
import com.tima.Iservice;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"trans.xml");

		Employee e1 = new Employee(19, "Alok", "Gupta");

		Iservice empservice = context.getBean("service", Iservice.class);

		Employee e2 = new Employee(20, "Yamini", "Gupta");
				
		List<Employee> lstEmployees = new ArrayList<Employee>();
		lstEmployees.add(e1);
		lstEmployees.add(e2);
		empservice.insertEmployees(lstEmployees);
	}
}
