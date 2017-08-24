package cn.hibernate.entity;

public class Carport {
	private Integer pid;
	private String location;//位置
	private Integer size;//大小
	private Car car;
	
	

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Carport(String location, Integer size) {
		super();
		this.location = location;
		this.size = size;
	}

	public Carport() {
	}

}
