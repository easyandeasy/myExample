package cn.hibernate.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 学生类
 * @author tang
 *
 */
//entity 表示需要持久化的实体类
@Entity
//实体类所对应的表
@Table
public class Book {
	//id主键 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	private String name;
	private double price;
	private String author;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPuDate() {
		return puDate;
	}
	public void setPuDate(Date puDate) {
		this.puDate = puDate;
	}
	private Date puDate;
	
}
