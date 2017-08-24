package test.cn.ssh.springtest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ssh.service.TestService;

public class SpringTest {

	@Test
	public void main() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac.getBean("testAction"));
	}

	// 测试sessionFactory
	@Test
	public void testSessionFactory() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object session = ac.getBean("sessionFactory");
		System.out.println(session);
	}

	// 测试事物
	@Test
	public void testTransaction() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService service = (TestService) ac.getBean("testService");
		service.saveUser();
		
	}

}
