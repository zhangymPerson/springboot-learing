package cn.danao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhang
 * @version 1.0
 * @classname Application
 * @descriptionclass class describe
 * 1.测试spring
 * 2.****************
 * @createdate 2019/4/25
 * @since 1.0
 */
public class Application {

	public static void main(String[] args) {
		System.out.println("测试");
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Object object = context.getBean("user");
		System.out.println(object);
	}

}
