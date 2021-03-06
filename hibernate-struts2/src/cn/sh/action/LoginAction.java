package cn.sh.action;

import cn.sh.bean.User;
import cn.sh.service.LoginService;
import cn.sh.service.impl.LoginServiceImpl;

public class LoginAction {

	LoginService service = new LoginServiceImpl();
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public LoginAction() {}
	
	public String execute() {
		System.out.println(user.getName());
		boolean flag = service.isLogin(user);
		if(!flag) {
			return "error";
		}
		return "success";
	}
}
