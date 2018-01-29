import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tima.Manager;
import com.tima.MyConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		
		Employee emp = (Employee) context.getBean("e1");
		//Employee emp1 = context.getBean("e3", Employee.class);
		System.out.println("Employee" + emp);
		
		try {
			emp.doDestroy();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		*/
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Manager mgr = (Manager) context.getBean("m11");
		System.out.println("Manager" + mgr);
	}

}
