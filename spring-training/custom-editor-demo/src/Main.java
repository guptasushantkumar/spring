import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tima.Person;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext(
		//		"beans.xml","editors.xml");
		
		Person p1 = context.getBean("person", Person.class);

		System.out.println("Person name: " + p1.getName());
		System.out.println("Country code: " + p1.getPhone().getCountryCode());
		System.out.println("City code: " + p1.getPhone().getCityCode());
		System.out.println("Number: " + p1.getPhone().getNumber());

	}

}
