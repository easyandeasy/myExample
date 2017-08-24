package cn.hibernate.entity;

public class Car2 {
	private Integer cid;
	private String number;//车牌号
	private String brand;//品牌
	private Carport2 port;
	

	public Carport2 getPort() {
		return port;
	}

	public void setPort(Carport2 port) {
		this.port = port;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Car2(String number, String brand) {
		this.number = number;
		this.brand = brand;
	}

	public Car2() {
	}
}