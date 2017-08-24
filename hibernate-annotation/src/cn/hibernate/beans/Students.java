package cn.hibernate.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Students implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sclass")
	private Classs cls;
	public Classs getCls() {
		return cls;
	}
	public void setCls(Classs cls) {
		this.cls = cls;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Students(String sname) {
		this.sname = sname;
	}
	public Students() {}
	
}
