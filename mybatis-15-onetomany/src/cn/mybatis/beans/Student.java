package cn.mybatis.beans;

//学生
public class Student {

	private Integer id;
	private String sname;
	private String sbirth;
	private String sclass;
	private String saddress;
	private Classs cls;
	
	public Classs getCls() {
		return cls;
	}
	public void setCls(Classs cls) {
		this.cls = cls;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSbirth() {
		return sbirth;
	}
	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Student() {
		super();
	}
	public Student(Integer id, String sname, String sbirth, String sclass, String saddress) {
		super();
		this.id = id;
		this.sname = sname;
		this.sbirth = sbirth;
		this.sclass = sclass;
		this.saddress = saddress;
	}
	public Student(String sname, String sbirth, String sclass, String saddress) {
		this.sname = sname;
		this.sbirth = sbirth;
		this.sclass = sclass;
		this.saddress = saddress;
	}
}
