package com.car.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.car.beans.Car;
import com.car.dao.ICarDao;
import com.car.utils.MybatisUtil;

public class CarServiceImpl implements ICarService{
	
	private SqlSession session = MybatisUtil.getSqlSession();
	private ICarDao dao = session.getMapper(ICarDao.class);
	
	/**
	 * 查询所有车的信息
	 * @return
	 */
	public List<Car> queryCarMap() {
		List<Car> cars = dao.selectCarMap();
		return cars;
	}
	
	@Test
	public void test() {
		SqlSession session = MybatisUtil.getSqlSession();
		ICarDao dao = session.getMapper(ICarDao.class);
		List<Car> map = dao.selectCarMap();
//		List<Map> map = dao.selectUserMap();
		for (Car m : map) {
			System.out.println(m.getCname());
		}
	}
	
}
