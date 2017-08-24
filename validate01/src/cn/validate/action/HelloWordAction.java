package cn.validate.action;

import org.apache.struts2.ServletActionContext;

import cn.validate.util.Locales;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWordAction extends ActionSupport {

	private Locales locales;
	public Locales getLocales() {
		return locales;
	}
	public void setLocales(Locales locales) {
		this.locales = locales;
	}
	@Override
	public String execute() throws Exception {
		//ServletActionContext.getRequest().setAttribute("", Locales.getLocales());
		return SUCCESS;
	}
}
