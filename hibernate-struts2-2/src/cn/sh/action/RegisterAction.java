package cn.sh.action;

import cn.sh.bean.User;
import cn.sh.service.LoginService;
import cn.sh.service.impl.LoginServiceImpl;

public class RegisterAction {

	LoginService service = new LoginServiceImpl();
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RegisterAction() {}
	
	public String execute() {
		System.out.println(user.getName() + "\t" +user.getPwd());
		boolean flag = service.addUser(user);
		if(!flag) {
			return "error";
		}
		return "success";
	}
}
