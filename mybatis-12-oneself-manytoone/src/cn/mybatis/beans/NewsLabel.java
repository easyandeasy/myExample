package cn.mybatis.beans;

import java.util.Set;

/**
 * 新闻栏目实体类：当前新闻栏目被看作为多方，即子栏目
 * 
 * @author tang
 *
 */
public class NewsLabel {

	private Integer id;
	private String name;
	private NewsLabel parent;

	public NewsLabel getParent() {
		return parent;
	}

	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NewsLabel(String name) {
		this.name = name;
	}

	public NewsLabel() {
		super();
	}

	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}

}
