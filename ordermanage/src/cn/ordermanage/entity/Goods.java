package cn.ordermanage.entity;

/**
 * 商品类
 * @author tang
 *
 */
public class Goods {

	private int id;//编号
	private String name;//书名
	private double price;//价格
	private String specification;//商品介绍
	private String manufcturer;//制造商
	
	public Goods() {}

	public Goods(int id, String name, double price, String specification,
			String manufcturer) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.specification = specification;
		this.manufcturer = manufcturer;
	}

	public Goods(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Goods(String name, double price) {
		this.name = name;
		this.price = price;
	}

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
