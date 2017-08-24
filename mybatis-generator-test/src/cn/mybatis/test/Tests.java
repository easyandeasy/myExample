package cn.mybatis.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.beans.User;
import cn.mybatis.beans.UserExample;
import cn.mybatis.beans.UserExample.Criteria;
import cn.mybatis.dao.UserMapper;
import cn.mybatis.utils.MybatisUtil;

public class Tests {
	
	private SqlSession session;
	private UserMapper mapper;
	@Before
	public void before() {
		session = MybatisUtil.getSqlSession();
		mapper = session.getMapper(UserMapper.class);
	}

	@Test
	public void testInsert() {
		if(session != null) {
			session.close();
		}
	}
	
	//查询 
	@Test
	public void test01() {
		//根据主键id查询
//		User selectByPrimaryKey = mapper.selectByPrimaryKey(1);
//		System.out.println(selectByPrimaryKey.getName());
		
		//添加条件进行查询
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%t%");//模糊查询
		List<User> byExample = mapper.selectByExample(example);
		for (User user : byExample) {
			System.out.println(user.getName());
		}
	}
	
	//查询 表中记录数
	@Test
	public void test02() {
		//无条件查询记录数
//		UserExample example = new UserExample();
//		int count = mapper.countByExample(example);
//		System.out.println(count);
		
		//添加条件进行查询记录数
		UserExample example2 = new UserExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andNameEqualTo("tang");
		example2.or(criteria2);
		int count2 = mapper.countByExample(example2);
		System.out.println(count2);
	}
	
	//修改 数据
	@Test
	public void test03() {
		// 一、修改全部字段的值，《建议查询出来进行修改》
		// record:是要修改的对象，example：是添加条件
		
//		User record1 = mapper.selectByPrimaryKey(2);//从数据库中将修改的对象查询出来
//		record1.setName("jing");//对查询出来的对象进行修改
//		UserExample example1 = new UserExample();//添加条件对象
//		Criteria criteria1 = example1.createCriteria();//创建标准对象
//		criteria1.andNameEqualTo("tang");//进行添加条件
//		int update1 = mapper.updateByExample(record1, example1);//执行修改操作,返回的是受影响的行数
		
		
		
		// 二 、修改对象中的属性字段不为空的，一般实用在批量修改
		
//		User record2 = new User();
//		record2.setName("admin");
//		record2.setPwd("admin");
//		UserExample example2 = new UserExample();
//		Criteria criteria2 = example2.createCriteria();
//		criteria2.andIdEqualTo(1);
//		mapper.updateByExampleSelective(record2, example2);
		
		
		// 三 、根据主键id进行全部修改，《建议查询出来进行修改》
		
//		User record3 = mapper.selectByPrimaryKey(2);
//		record3.setName("tang");
//		record3.setPwd("tang");
//		mapper.updateByPrimaryKey(record3);
		
		
		// 四 、根据主键id时行修改不为空的属性对应的字段
		User record4 = new User();
		record4.setId(3);
		record4.setName("jack");
		mapper.updateByPrimaryKeySelective(record4);
		
		session.commit();//进行提交数据
	}
	
	
	
	//添加  数据
	@Test
	public void test04() {
		// 一 、插入全部的数据，可以为空，但前提是数据库中的字段是可以为空的
		
//		User record = new User();
//		record.setName("insert2");
//		record.setPwd("insert1");
//		mapper.insert(record);
		
		// 二 、插入不为空的属性对应的字段
		User record = new User();
		record.setName("insert3");
		mapper.insertSelective(record);
		
		session.commit();//进行提交数据
	}
	
	
	//删除  数据
	@Test
	public void test05() {
		// 一 、根据主键id进行删除操作
		
//		mapper.deleteByPrimaryKey(12);
		
		// 二 、根据条件进行删除
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		List<String> values = new ArrayList<String>();
		values.add("insert2");
		values.add("insert3");
		criteria.andNameIn(values);
		mapper.deleteByExample(example);
		
		session.commit();//进行提交数据
	}
}













/*generatorConfig.xml跟src同级*/
/*
public void generator() throws Exception {
	   List<String> warnings = new ArrayList<String>();
	   boolean overwrite = true;
	   File configFile = new File("generatorConfig.xml");
	   ConfigurationParser cp = new ConfigurationParser(warnings);
	   Configuration config = cp.parseConfiguration(configFile);
	   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	   myBatisGenerator.generate(null);
}

public static void main(String[] args) throws Exception {
	Tests test = new Tests();
	test.generator();
}

*/
