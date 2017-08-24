package cn.hibernate.createdb;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.util.HibernateUtils;
import cn.ordermanage.entity.Goods;
import cn.ordermanage.entity.Orders;


/**	
 * 创建表
 * @author tang
 *
 */
public class HibernateTest {

	@Test
	public void createDB() {
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//第一个参数是否生成ddl脚本，第二个参数是否执行到数据库中
		se.create(true, true);
	}
	
	@Test
	public void sqlSave() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			

			Goods g = new Goods();
			g.setPrice(108.0);
			g.setName("Java编程思想");
			g.setSpecification("本书赢得全球程序员的广泛赞誉");
			g.setManufcturer("机械工程出版社");
			
			Goods gg = new Goods();
			gg.setPrice(98.0);
			gg.setName("Java核心技术");
			gg.setSpecification("针对Java SE6平台进行了全面更新，涵盖Java语言核心内容");
			gg.setManufcturer("机械工程出版社");
			
			Goods ggg = new Goods();
			ggg.setPrice(68.0);
			ggg.setName("Java经典实例");
			ggg.setSpecification("本书对于Java开发人员而言是理想的“第二本书”讲述API比一般书籍要详细，非常适合扩大Java应用的知识面");
			ggg.setManufcturer("中国电力出版社");
			
			session.save(g);
			session.save(gg);
			session.save(ggg);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtils.closeSession();
		}
	}
	
	
	
	
	@Test
	public void test() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Goods g = (Goods)session.get(Goods.class, 1);
			System.out.println(g.getName());
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtils.closeSession();
		}
	}
	
	@Test
	public void testhql() {
		//创建Query对象
		Session session = HibernateUtils.getSession();
		//Transaction tx = session.beginTransaction();
		
		//Goods 大写 表示的是  cn.siggy.pojo.Goods类
		//name表示的 Book类中的属性名
		//list()方法返回查询结果
		
		//1.查询单个属性	（返回结果的类型，根据查询的列来定）
		//List<String> list = session.createQuery("select name from Goods").list();
		
		//2.查询多个属性	（返回结果的数组集合，数组中元素的类型根据查询的列来定）
		//List<Object[]> list = session.createQuery("select name,price from Goods").list();
		
		//3.查询多个列时  返回结果是数组集合 数组中元素的类型 是由查询列来决定 (需要查询对应的类中有带参的构造方法，参数是要查询的的属性)
		//List<Goods> list = session.createQuery("select new Goods(g.name,g.price) from Goods g").list();
		
		
		//4.查询所有的列，不使用select (返回类型是对应查询该类的这个对象)
		//List<Goods> list = session.createQuery("from Goods").list();
		
		//5.查询所有的列，用select (返回类型是对应查询该类的这个对象)
		//List<Goods> list = session.createQuery("select g from Goods g").list();
		
		//6.查询所有的列，使用点位符——? 使用setInteger() 从零开始 (返回类型是对应查询该类的这个对象)
		//List<Goods> list = session.createQuery("from Goods g where id<?").setInteger(0, 3).list();
		
		//7.查询所有的列，使用点位符——? 使用setParameter() 从零开始 (返回类型是对应查询该类的这个对象)
		//List<Goods> list = session.createQuery("from Goods g where id=?").setParameter(0, 3).list();
		
		//<命名查询>《设置条件参数的名称，以冒号开头后跟名称，设置参数时，只需指定冒号后的名称》
		//8.查询所有的列，使用点位符——? 使用setParameter() 从零开始 (返回类型是对应查询该类的这个对象)
		//List<Goods> list = session.createQuery("from Goods g where id=:id").setParameter("id", 2).list();
		
		
		//9.查询所有的列:<分页查询>
		//int now = 3; //当前页
		//int pageSize = 3;//每页显示数据条数
		//List<Goods> list = session.createQuery("from Goods g").setFirstResult((now-1)*pageSize).setMaxResults(pageSize).list();
		
		
		//10.聚合函数查询
			//统计查询 MAX
			//Number max = (Number)session.createQuery("select max(g.price) from Goods g").uniqueResult();
			//System.out.println(max.doubleValue());
			
			//统计查询 MIN
			//Number min = (Number)session.createQuery("select min(g.price) from Goods g").uniqueResult();
			//System.out.println(min.doubleValue());
		
			//统计查询/分组查询 count、group by
			//List<Object[]> obj = session.createQuery("select g.name,count(g.id) from Goods g group by g.name").list();
			/*for(Object[] g:obj){
				System.out.println(g[0]+"\t-------\t"+g[1]);
			}*/
			
			//排序查询  order by 《desc 降序、asc 升序》
			/*List<Goods> list = session.createQuery("from Goods g order by g.id asc").list();
			for(Goods g:list){
				System.out.println(g.getName()+"\t"+g.getPrice()+"\t"+g.getId());
			}*/
			
		//11.连接查询
			//对象导航
			List<Orders> list = session.createQuery("select o from Orders o").list();
			for(Orders g:list){
				System.out.println(g.getId()+"\t"+g.getName());
			}
		/*for(int g:list){
			System.out.println(g.getName()+"\t"+g.getPrice()+"\t"+g.getId());
		}*/
		//tx.commit();
		HibernateUtils.closeSession();
	}
}
