package cn.hibernate.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.hibernate.beans.Classs;
import cn.hibernate.beans.Students;
import cn.hibernate.util.HibernateUtil;

public class TestsCriteria {

	private Session session;
	private Transaction tx;
	
	@Before
	public void before() {
		session = HibernateUtil.getSession();
	}
	
	@After
	public void after() {
		HibernateUtil.closeSession();
	}
	@Test
	public void test01() {
		//原sql语句查询 一：返回的是对象数组
		String sql = "select * from students";
		List<Object[]> list = session.createSQLQuery(sql).list();
		for (Object[] objects : list) {
			System.out.println(objects[0] + "\t" + objects[1]);
		}
	}
	
	@Test
	public void save() {
		try {
			tx = session.beginTransaction();
			Students stu = new Students("李四666");
			session.save(stu);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
	}
	
	
	@Test
	public void testCriteria() {
		Criteria criterias = session.createCriteria(Students.class);
		List<Students> stus = criterias.list();
		for (Students stu : stus) {
			System.out.println(stu.getSname() + "\t" + stu.getSid());
		}
		
		
		
		//条件查询:sid 等于 （eq）
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.eq("sid",2)).list();
		//条件查询:sid 不等于 （ne）
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.ne("sid",2)).list();
		/*Criteria cr = session.createCriteria(Students.class);
		Criterion eq = Restrictions.eq("sid", 1);
		cr = cr.add(eq);
		List<Students> list = cr.list();
		for (Students s : list) {
			System.out.println(s.getSname());
		}
		 */
		
		for (Students s : list) {
			System.out.println(s.getSname());
		}
	}
	
	
	//比较运算符
	@Test
	public void testLt() {
		// sid 小于（lt） 
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.lt("sid",2)).list();
		// sid 大于（gt）
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.gt("sid",3)).list();
		// sid 大于（gt）
//		Criterion c = Restrictions.eq("sid",new Object[]{1,2,3});
		// sid 不等于 （not(eq)） eq：等于
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.eq("sid",1))).list();
		// sid 大于等于 （ge）
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.ge("sid", 3)).list();
		// sid 小于等于 （le）
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.le("sid", 3)).list();
		// sname 等于空值 （isNull）
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.isNull("sname")).list();
		// sname 非空值 （）
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.isNotNull("sname")).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	
	//范围运算符 in 和 not in 的使用
	@Test
	public void test04() {
		// sid 等于列表中的某一个值 （in）、可以是集合、可以是数组
		Collection<Integer> co = new ArrayList<Integer>();//集合
		co.add(1);
		co.add(2);
		co.add(3);
		// in 集合
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.in("sid",co)).list();
		// in 数组
//		List<Students> arry = session.createCriteria(Students.class).add(Restrictions.in("sid",new Object[]{4,5,6})).list();
		// not in 集合
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.in("sid",co))).list();
		// not in 数组
//		List<Students> arry = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.in("sid",new Object[]{4,5,6}))).list();
		
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	//范围运算符 between 和 not between
	@Test
	public void test05() {
		// 在两数之间的任意值	 between
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.between("sid", 1, 3)).list();
		// 除了两个数之间的任意值  not between
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.between("sid", 1, 3))).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	// 字符串模式匹配  like 和  ilike
	@Test
	public void test06() {
//		MatchMode.ANYWHERE //包含
//		MatchMode.START  //开头
//		MatchMode.END	 //结束
//		MatchMode.EXACT	 //等于
		//使用Restrictions.like() ，执行语句是：this_.sname like ?
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.like("sname", "六",MatchMode.START)).list();
		//使用  Restrictions.ilike()方法，忽略了大小写。执行语句是：lower(this_.sname) like ?
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.ilike("sname", "六",MatchMode.START)).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	
	// 逻辑运算符
	@Test
	public void test07() {
		// 逻辑与  执行的语句是： (this_.sid=? and this_.sname=?)
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.and(Restrictions.eq("sid", 1),Restrictions.eq("sname", "张三"))).list();
		// 逻辑或  执行的语句是：(this_.sid=? or this_.sid=?)
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.or(Restrictions.eq("sid", 1),Restrictions.eq("sid", 4))).list();
		// 逻辑非  执行的语句是：not (this_.sid=?)
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.eq("sid", 1))).list();
		// 逻辑或 当条件有多个时 使用  执行的语句是：(this_.sid=? or this_.sname=? or this_.sid=?)
			// 第一种方式
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.disjunction(Restrictions.eq("sid", 1),Restrictions.eq("sname", "李四"),Restrictions.eq("sid", 8))).list();
			// 第二种方式
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.disjunction().add(Restrictions.eq("sid", 1)).add(Restrictions.eq("sname", "李四")).add(Restrictions.eq("sid", 8))).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	
	//集合运算
	@Test
	public void test08() {
		// 判断集合为空（isEmpty） 
		// 判断集合为空：students集合是定义在实体Classs中的集合名称，在查询Classs实体的时候判断该集合为空，
		// 为空则班级没有学生，输出没有学生的班级名称
//		List<Classs> list = session.createCriteria(Classs.class).add(Restrictions.isEmpty("students")).list();
		
		// 判断集合不为空 （isNotEmpty）
		// 判断集合不为空：students集合是定义在实体Classs中的集合名称，在查询Classs实体的时候判断该集合不为空，
		// 不为空则班级有学生，输出有学生的班级名称
		List<Classs> list = session.createCriteria(Classs.class).add(Restrictions.isNotEmpty("students")).list();
		for (Classs s : list) {
			System.out.println(s.getCname());
		}
	}
	
	
	
	
	
	// 排序	 默认是（升序 Order.asc）
	@Test
	public void test10() {
		// 降序  （Order.desc）
		List<Students> stus = session.createCriteria(Students.class).addOrder(Order.desc("sname")).list();
		for (Students stu : stus) {
			System.out.println(stu.getSid() + "\t" + stu.getSname());
		}
	}
	
	
	
	//分页
	@Test
	public void test11() {
		List<Students> stus = session.createCriteria(Students.class).add(Restrictions.isNotNull("sname")).setFirstResult(0).setMaxResults(3).list();
		for (Students stu : stus) {
			System.out.println(stu.getSid() + "\t" + stu.getSname());
		}
	}
	
	
	
	// 查询唯一对象
	@Test
	public void test12() {
		Students stu = (Students) session.createCriteria(Students.class).add(Restrictions.isNotNull("sname")).addOrder(Order.desc("sid")).setMaxResults(1).uniqueResult();
		System.out.println(stu.getSid() + "\t" + stu.getSname() );//+ "\t" + stu.getCls().getCname()
	}
	
	
	
	
	// 连接查询：    Criteria 只支持 内连接 和  迫切左外连接。
	// 去除重复的数据，可以使用Set接口的袜类HashSet来过滤重复的数据
	@Test
	public void test13() {
		// 内连接查询 一、（createCriteria）
//		List<Classs> list = session.createCriteria(Classs.class).add(Restrictions.eq("cname", "s1")).createCriteria("students").add(Restrictions.like("sname", "六",MatchMode.ANYWHERE)).list();
		// 内连接查询 二、（createAlias）
//		List<Classs> list = session.createCriteria(Classs.class,"cl").createAlias("students", "stu").add(Restrictions.eq("cl.cname", "s1")).add(Restrictions.like("stu.sname", "六",MatchMode.ANYWHERE)).list();
		// 迫切左外连接	（setFetchMode("students", FetchMode.JOIN)）
		List<Classs> list = session.createCriteria(Classs.class).setFetchMode("students", FetchMode.JOIN).add(Restrictions.eq("cname", "s1")).list();
		
		//使用HashSet过滤重复的数据
		HashSet<Classs> set = new HashSet<Classs>(list);
		
		for (Classs cl : set) {
			System.out.println(cl.getCname() + "的学生有：" + cl.getStudents().size() + "个");
			Iterator it = cl.getStudents().iterator();
			while (it.hasNext()) {
				Students stu = (Students) it.next();
				System.out.println(stu.getSid() + "\t" + stu.getSname());
			}
		}
	}
	
	
	
	// 投影查询：
	@Test
	public void test14() {
		// 查询一个投影属性
//		List<String> stu = session.createCriteria(Students.class).setProjection(Property.forName("sname")).list();
//		for (String obj : stu) {
//			System.out.println(s);
//		}
		// 查询多个投影属性
		List<Object[]> cls = session.createCriteria(Students.class).setProjection(Projections.projectionList().add(Property.forName("sid")).add(Property.forName("sname"))).list();
		for (Object[] obj : cls) {
			System.out.println(obj[0] + "\t" + obj[1]);
		}


		// 统计记录数 / 最小值   /  平均值    / 最大值   /   统计某一字段非空记录数    /   针对某一字段求和
//		List<Object[]> lists = session.createCriteria(Students.class).setProjection(Projections.projectionList().add(Projections.rowCount()).add(Projections.min("sid")).add(Projections.avg("sid")).add(Projections.max("sid")).add(Projections.count("sname")).add(Projections.sum("sid"))).list();
//		for (Object[] o : lists) {
//			System.out.println("统计记录数:" + o[0] + "\n最小值:" + o[1] + "\n平均值:" + o[2] + "\n最大值:" + o[3] + "\n统计某一字段非空记录数:" + o[4] + "\n针对某一字段求和:" + o[5]);
//		}
	}
	
}