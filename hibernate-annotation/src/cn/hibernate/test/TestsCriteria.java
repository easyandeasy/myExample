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
		//ԭsql����ѯ һ�����ص��Ƕ�������
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
			Students stu = new Students("����666");
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
		
		
		
		//������ѯ:sid ���� ��eq��
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.eq("sid",2)).list();
		//������ѯ:sid ������ ��ne��
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
	
	
	//�Ƚ������
	@Test
	public void testLt() {
		// sid С�ڣ�lt�� 
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.lt("sid",2)).list();
		// sid ���ڣ�gt��
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.gt("sid",3)).list();
		// sid ���ڣ�gt��
//		Criterion c = Restrictions.eq("sid",new Object[]{1,2,3});
		// sid ������ ��not(eq)�� eq������
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.eq("sid",1))).list();
		// sid ���ڵ��� ��ge��
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.ge("sid", 3)).list();
		// sid С�ڵ��� ��le��
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.le("sid", 3)).list();
		// sname ���ڿ�ֵ ��isNull��
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.isNull("sname")).list();
		// sname �ǿ�ֵ ����
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.isNotNull("sname")).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	
	//��Χ����� in �� not in ��ʹ��
	@Test
	public void test04() {
		// sid �����б��е�ĳһ��ֵ ��in���������Ǽ��ϡ�����������
		Collection<Integer> co = new ArrayList<Integer>();//����
		co.add(1);
		co.add(2);
		co.add(3);
		// in ����
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.in("sid",co)).list();
		// in ����
//		List<Students> arry = session.createCriteria(Students.class).add(Restrictions.in("sid",new Object[]{4,5,6})).list();
		// not in ����
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.in("sid",co))).list();
		// not in ����
//		List<Students> arry = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.in("sid",new Object[]{4,5,6}))).list();
		
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	//��Χ����� between �� not between
	@Test
	public void test05() {
		// ������֮�������ֵ	 between
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.between("sid", 1, 3)).list();
		// ����������֮�������ֵ  not between
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.between("sid", 1, 3))).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	// �ַ���ģʽƥ��  like ��  ilike
	@Test
	public void test06() {
//		MatchMode.ANYWHERE //����
//		MatchMode.START  //��ͷ
//		MatchMode.END	 //����
//		MatchMode.EXACT	 //����
		//ʹ��Restrictions.like() ��ִ������ǣ�this_.sname like ?
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.like("sname", "��",MatchMode.START)).list();
		//ʹ��  Restrictions.ilike()�����������˴�Сд��ִ������ǣ�lower(this_.sname) like ?
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.ilike("sname", "��",MatchMode.START)).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	
	// �߼������
	@Test
	public void test07() {
		// �߼���  ִ�е�����ǣ� (this_.sid=? and this_.sname=?)
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.and(Restrictions.eq("sid", 1),Restrictions.eq("sname", "����"))).list();
		// �߼���  ִ�е�����ǣ�(this_.sid=? or this_.sid=?)
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.or(Restrictions.eq("sid", 1),Restrictions.eq("sid", 4))).list();
		// �߼���  ִ�е�����ǣ�not (this_.sid=?)
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.not(Restrictions.eq("sid", 1))).list();
		// �߼��� �������ж��ʱ ʹ��  ִ�е�����ǣ�(this_.sid=? or this_.sname=? or this_.sid=?)
			// ��һ�ַ�ʽ
//		List<Students> list = session.createCriteria(Students.class).add(Restrictions.disjunction(Restrictions.eq("sid", 1),Restrictions.eq("sname", "����"),Restrictions.eq("sid", 8))).list();
			// �ڶ��ַ�ʽ
		List<Students> list = session.createCriteria(Students.class).add(Restrictions.disjunction().add(Restrictions.eq("sid", 1)).add(Restrictions.eq("sname", "����")).add(Restrictions.eq("sid", 8))).list();
		for (Students s : list) {
			if(s.getSname() != null) {
				System.out.println(s.getSname());
			} else {
				System.out.println(s.getSid());
			}
		}
	}
	
	
	
	//��������
	@Test
	public void test08() {
		// �жϼ���Ϊ�գ�isEmpty�� 
		// �жϼ���Ϊ�գ�students�����Ƕ�����ʵ��Classs�еļ������ƣ��ڲ�ѯClasssʵ���ʱ���жϸü���Ϊ�գ�
		// Ϊ����༶û��ѧ�������û��ѧ���İ༶����
//		List<Classs> list = session.createCriteria(Classs.class).add(Restrictions.isEmpty("students")).list();
		
		// �жϼ��ϲ�Ϊ�� ��isNotEmpty��
		// �жϼ��ϲ�Ϊ�գ�students�����Ƕ�����ʵ��Classs�еļ������ƣ��ڲ�ѯClasssʵ���ʱ���жϸü��ϲ�Ϊ�գ�
		// ��Ϊ����༶��ѧ���������ѧ���İ༶����
		List<Classs> list = session.createCriteria(Classs.class).add(Restrictions.isNotEmpty("students")).list();
		for (Classs s : list) {
			System.out.println(s.getCname());
		}
	}
	
	
	
	
	
	// ����	 Ĭ���ǣ����� Order.asc��
	@Test
	public void test10() {
		// ����  ��Order.desc��
		List<Students> stus = session.createCriteria(Students.class).addOrder(Order.desc("sname")).list();
		for (Students stu : stus) {
			System.out.println(stu.getSid() + "\t" + stu.getSname());
		}
	}
	
	
	
	//��ҳ
	@Test
	public void test11() {
		List<Students> stus = session.createCriteria(Students.class).add(Restrictions.isNotNull("sname")).setFirstResult(0).setMaxResults(3).list();
		for (Students stu : stus) {
			System.out.println(stu.getSid() + "\t" + stu.getSname());
		}
	}
	
	
	
	// ��ѯΨһ����
	@Test
	public void test12() {
		Students stu = (Students) session.createCriteria(Students.class).add(Restrictions.isNotNull("sname")).addOrder(Order.desc("sid")).setMaxResults(1).uniqueResult();
		System.out.println(stu.getSid() + "\t" + stu.getSname() );//+ "\t" + stu.getCls().getCname()
	}
	
	
	
	
	// ���Ӳ�ѯ��    Criteria ֻ֧�� ������ ��  �����������ӡ�
	// ȥ���ظ������ݣ�����ʹ��Set�ӿڵ�����HashSet�������ظ�������
	@Test
	public void test13() {
		// �����Ӳ�ѯ һ����createCriteria��
//		List<Classs> list = session.createCriteria(Classs.class).add(Restrictions.eq("cname", "s1")).createCriteria("students").add(Restrictions.like("sname", "��",MatchMode.ANYWHERE)).list();
		// �����Ӳ�ѯ ������createAlias��
//		List<Classs> list = session.createCriteria(Classs.class,"cl").createAlias("students", "stu").add(Restrictions.eq("cl.cname", "s1")).add(Restrictions.like("stu.sname", "��",MatchMode.ANYWHERE)).list();
		// ������������	��setFetchMode("students", FetchMode.JOIN)��
		List<Classs> list = session.createCriteria(Classs.class).setFetchMode("students", FetchMode.JOIN).add(Restrictions.eq("cname", "s1")).list();
		
		//ʹ��HashSet�����ظ�������
		HashSet<Classs> set = new HashSet<Classs>(list);
		
		for (Classs cl : set) {
			System.out.println(cl.getCname() + "��ѧ���У�" + cl.getStudents().size() + "��");
			Iterator it = cl.getStudents().iterator();
			while (it.hasNext()) {
				Students stu = (Students) it.next();
				System.out.println(stu.getSid() + "\t" + stu.getSname());
			}
		}
	}
	
	
	
	// ͶӰ��ѯ��
	@Test
	public void test14() {
		// ��ѯһ��ͶӰ����
//		List<String> stu = session.createCriteria(Students.class).setProjection(Property.forName("sname")).list();
//		for (String obj : stu) {
//			System.out.println(s);
//		}
		// ��ѯ���ͶӰ����
		List<Object[]> cls = session.createCriteria(Students.class).setProjection(Projections.projectionList().add(Property.forName("sid")).add(Property.forName("sname"))).list();
		for (Object[] obj : cls) {
			System.out.println(obj[0] + "\t" + obj[1]);
		}


		// ͳ�Ƽ�¼�� / ��Сֵ   /  ƽ��ֵ    / ���ֵ   /   ͳ��ĳһ�ֶηǿռ�¼��    /   ���ĳһ�ֶ����
//		List<Object[]> lists = session.createCriteria(Students.class).setProjection(Projections.projectionList().add(Projections.rowCount()).add(Projections.min("sid")).add(Projections.avg("sid")).add(Projections.max("sid")).add(Projections.count("sname")).add(Projections.sum("sid"))).list();
//		for (Object[] o : lists) {
//			System.out.println("ͳ�Ƽ�¼��:" + o[0] + "\n��Сֵ:" + o[1] + "\nƽ��ֵ:" + o[2] + "\n���ֵ:" + o[3] + "\nͳ��ĳһ�ֶηǿռ�¼��:" + o[4] + "\n���ĳһ�ֶ����:" + o[5]);
//		}
	}
	
}