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

		Employee e1 = new Employee(11, "Alok", "Gupta");

		Iservice empservice = context.getBean("service", EmployeeService.class);

		// empservice.insertEmployee(e1);
		Employee e2 = new Employee(12, "Yaminiq", "Gupta");
		e2 = null;
		// empservice.updateEmployee(e2);

		// List<Employee> emp = empservice.getAllEmployees();
		// for (Employee empp : emp) {
		// System.out.println("Employee: " + empp.toString());

		// }

		// Employee e3 = empservice.getEmployeeById(2);

		// System.out.println("Employee: " + e3);

		// System.out.println(empservice.getEmployeeCOunt());
		List<Employee> lstEmployees = new ArrayList<Employee>();
		lstEmployees.add(e1);
		lstEmployees.add(e2);
		empservice.insertEmployees(lstEmployees);
	}
}
