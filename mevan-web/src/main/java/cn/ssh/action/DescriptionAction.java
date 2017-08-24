package cn.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import cn.ssh.beans.Description;
import cn.ssh.service.IDescriptionService;

@Controller
@Scope("prototype")// 表示是一多例的action
public class DescriptionAction extends ActionSupport implements ModelDriven<Description>{

	@Resource	
	private IDescriptionService descriptionService;
	
	private Long parentId;
	
	/*使用 ModelDriven 进行封装*/
	private Description model = new Description();
	
	public Description getModel() {
		return model;
	}
	
	/** 列表 */
	public String list() {
		List<Description> descriptionList = descriptionService.findAll();
		ActionContext.getContext().put("descriptionList",descriptionList);//将DescriptionList存放到 值栈中    使用ognl表达式获取 #{DescriptionList}
		return "list";
	}

	/** 删除 */
	public String delete() {
		descriptionService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() {
		//准备数据
		List<Description> descriptionList = descriptionService.findAll();
		ActionContext.getContext().put("descriptionList", descriptionList);
		return "saveUI";
	}

	/** 添加 */
	public String add() {
		/*使用  ModelDriven 后*/
		Description parent = descriptionService.getById(parentId);
		model.setParent(parent);
		descriptionService.addDescription(model);
		return "toList";
	}

	
	/** 修改页面 */
	public String editUI() {
		//准备数据
		List<Description> descriptionList = descriptionService.findAll();
		ActionContext.getContext().put("descriptionList", descriptionList);
		//准备回显数据
		//Description description = descriptionService.getById(model.getId());//获取要修改的对象
		// 方式一
		//ActionContext.getContext().getValueStack().push(description);//将数据存放在栈顶

//		if(description.getId() != null) {
//			parentId = description.getParent().getId();
//		}
		return "saveUI";
	}

	/** 修改 */
	public String edit() {
		// 1.从数据库获取原数据
		Description Description = descriptionService.getById(model.getId());
		// 2.设置要修改的属性
		Description.setName(model.getName());
		Description.setDescription(model.getDescription());
		// 3.更新到数据库
		descriptionService.update(Description);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
