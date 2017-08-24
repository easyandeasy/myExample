package cn.ordermanage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品类
 * @author tang
 *
 */
@Entity
@Table
public class Goods {

	@Id
	private int id;//编号
	private String name;//书名
	private double price;//价格
	private String specification;//商品介绍
	private String manufcturer;//制造商
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufcturer() {
		return manufcturer;
	}
	public void setManufcturer(String manufcturer) {
		this.manufcturer = manufcturer;
	}
	
}
