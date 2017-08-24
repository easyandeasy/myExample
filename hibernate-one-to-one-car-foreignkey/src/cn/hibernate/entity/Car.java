package cn.hibernate.entity;

public class Car {
	private Integer cid;
	private String number;//车牌号
	private String brand;//品牌
	private Carport port;
	

	public Carport getPort() {
		return port;
	}

	public void setPort(Carport port) {
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

	public Car(String number, String brand) {
		this.number = number;
		this.brand = brand;
	}

	public Car() {
	}
}