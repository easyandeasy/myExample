package cn.ssh.action;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ssh.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")//表示是一多例的action
public class TestAction extends ActionSupport{
	
	
	@Resource
	private TestService testService;

	@Override
	public String execute() throws Exception {
		System.out.println("-------> execute()");
		testService.saveUser();
		return "success";
	}
}
