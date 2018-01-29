import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tima.ReportService;

/**
 * 
 */

/**
 * @author Administrator
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");

		ReportService rs = context.getBean("rs", ReportService.class);
		rs.generateReport();
		// rs.doDestroy();

		ConfigurableApplicationContext cts = (ConfigurableApplicationContext) context;
		cts.close();
	}

}
