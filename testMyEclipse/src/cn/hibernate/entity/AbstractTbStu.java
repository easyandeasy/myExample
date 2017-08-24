package cn.hibernate.entity;

/**
 * AbstractTbStu entity provides the base persistence definition of the TbStu
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTbStu implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String tname;
	private Integer tage;
	private Double tsource;

	// Constructors

	/** default constructor */
	public AbstractTbStu() {
	}

	/** full constructor */
	public AbstractTbStu(String tname, Integer tage, Double tsource) {
		this.tname = tname;
		this.tage = tage;
		this.tsource = tsource;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getTage() {
		return this.tage;
	}

	public void setTage(Integer tage) {
		this.tage = tage;
	}

	public Double getTsource() {
		return this.tsource;
	}

	public void setTsource(Double tsource) {
		this.tsource = tsource;
	}

}