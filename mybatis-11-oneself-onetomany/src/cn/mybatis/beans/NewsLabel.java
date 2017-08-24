package cn.mybatis.beans;

import java.util.Set;

/**
 * 新闻栏目实体类：当前新闻栏目被看作为一方，即父栏目
 * 
 * @author tang
 *
 */
public class NewsLabel {

	private Integer id;
	private String name;
	private Set<NewsLabel> newsLabel;

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

	public Set<NewsLabel> getNewsLabel() {
		return newsLabel;
	}

	public void setNewsLabel(Set<NewsLabel> newsLabel) {
		this.newsLabel = newsLabel;
	}

	public NewsLabel(String name) {
		this.name = name;
	}

	public NewsLabel() {
		super();
	}

	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", newsLabel=" + newsLabel + "]";
	}
}
