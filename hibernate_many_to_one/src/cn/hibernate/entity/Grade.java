package cn.hibernate.entity;

import java.io.Serializable;

/**
 * 年级类
 * @author tang
 *
 */
public class Grade implements Serializable{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
