package com.car.service;

import java.util.List;

import com.car.beans.Car;

public interface ICarService {

	/**
	 * 查询所有车的信息
	 * @return
	 */
	public List<Car> queryCarMap();
}
