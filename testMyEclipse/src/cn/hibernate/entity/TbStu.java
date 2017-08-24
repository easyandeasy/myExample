package cn.hibernate.entity;

/**
 * TbStu entity. @author MyEclipse Persistence Tools
 */
public class TbStu extends AbstractTbStu implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TbStu() {
	}

	/** full constructor */
	public TbStu(String tname, Integer tage, Double tsource) {
		super(tname, tage, tsource);
	}

}
