package cn.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ssh.beans.Role;
import cn.ssh.service.IRoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")// 表示是一多例的action
public class RoleAction extends ActionSupport implements ModelDriven<Role>{

	@Resource	
	private IRoleService roleService;
	
	/*使用model后，model会封装属性，所以注释这些自己定义的属性*/
//	private Long id;
//	private String name;
//	private String description;
	
	/*使用 ModelDriven 进行封装*/
	private Role model = new Role();
	
	public Role getModel() {
		return model;
	}
	
	/** 列表 */
	public String list() {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList",roleList);//将roleList存放到 值栈中    使用ognl表达式获取 #{roleList}
		return "list";
	}

	/** 删除 */
	public String delete() {
		roleService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() {
		return "saveUI";
	}

	/** 添加 */
	public String add() {
		
		/*未使用 ModelDriven 之前使用*/
//		Role role = new Role();
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
//		roleService.addUser(role);
		
		/*使用  ModelDriven 后*/
		roleService.addUser(model);
		return "toList";
	}

	
	/** 修改页面 */
	public String editUI() {
		//准备回显数据
		Role role = roleService.getById(model.getId());//获取要修改的对象
		// 方式一
		ActionContext.getContext().getValueStack().push(role);//将数据存放在栈顶
		// 方式二
//		this.name = role.getName();
//		this.description = role.getDescription();
		return "saveUI";
	}

	/** 修改 */
	public String edit() {
		// 1.从数据库获取原数据
		Role role = roleService.getById(model.getId());
		// 2.设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		// 3.更新到数据库
		roleService.update(role);
		return "toList";
	}

	
	/*使用model后，model会封装属性，所以注释这些自己定义的属性*/
//	public void setRoleService(IRoleService roleService) {
//		this.roleService = roleService;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	
}
