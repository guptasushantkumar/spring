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
				"jdbc.xml");

		Employee e1 = new Employee(2, "Sushant", "Gupta");

		Iservice empservice = context.getBean("service", EmployeeService.class);

		// empservice.insertEmployee(e1);
		Employee e2 = new Employee(1, "Madhu", "Gupta");
		// empservice.updateEmployee(e2);

		List<Employee> emp = empservice.getAllEmployees();
		for (Employee empp : emp) {
			// System.out.println("Employee: " + empp.toString());

		}

		Employee e3 = empservice.getEmployeeById(2);

		System.out.println("Employee: " + e3);
		
		System.out.println(empservice.getEmployeeCOunt());
	}
}
