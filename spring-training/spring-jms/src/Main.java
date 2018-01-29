import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tima.MessageReceiver;
import com.tima.MessageService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"jms.xml");

		MessageService msgservice = context.getBean("msgservice",
				MessageService.class);

		msgservice.sendMessage();
		
		//context.getBean("rec", MessageReceiver.class);

	}

}
