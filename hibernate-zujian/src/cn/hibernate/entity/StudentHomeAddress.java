package cn.hibernate.entity;

public class StudentHomeAddress {
	private String shomeStreet;
	private String shomeCity;
	private String shomeProvince;
	private String shomeZipCode;
	private StudentInfo studentInfo;
	public String getShomeStreet() {
		return shomeStreet;
	}
	public void setShomeStreet(String shomeStreet) {
		this.shomeStreet = shomeStreet;
	}
	public String getShomeCity() {
		return shomeCity;
	}
	public void setShomeCity(String shomeCity) {
		this.shomeCity = shomeCity;
	}
	public String getShomeProvince() {
		return shomeProvince;
	}
	public void setShomeProvince(String shomeProvince) {
		this.shomeProvince = shomeProvince;
	}
	public String getShomeZipCode() {
		return shomeZipCode;
	}
	public void setShomeZipCode(String shomeZipCode) {
		this.shomeZipCode = shomeZipCode;
	}
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
}
