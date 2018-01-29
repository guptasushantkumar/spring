import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tima.Employee;
import com.tima.IService;
import com.tima.MyConfig;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Employee e1 = new Employee(1, "Sushant", "Gupta");

		IService objEmpService = context.getBean("target", IService.class);
		objEmpService.insert(e1);
		//objEmpService.update(e1);
		//objEmpService.remove(e1);

	}

}
