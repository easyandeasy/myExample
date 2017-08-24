package com.car.dao;

import java.util.List;
import java.util.Map;

import com.car.beans.Car;

public interface ICarDao {

	/**
	 * 查询所有车的信息
	 * @return
	 */
	List<Car> selectCarMap();

}
