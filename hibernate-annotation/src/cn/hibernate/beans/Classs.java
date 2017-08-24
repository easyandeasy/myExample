package cn.hibernate.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Classs implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="sclass")
	private Set<Students> students;
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Classs(String cname) {
		super();
		this.cname = cname;
	}
	public Classs() {
	}
	@Override
	public String toString() {
		return "Classs [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}
}



