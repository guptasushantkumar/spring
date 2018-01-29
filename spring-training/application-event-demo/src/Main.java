import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tima.HRDepartment;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"events.xml");
		HRDepartment hrd = context.getBean("hr", HRDepartment.class);
		hrd.recruitEmployee();
	}

}
