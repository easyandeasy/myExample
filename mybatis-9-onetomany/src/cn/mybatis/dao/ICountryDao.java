package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Country;

public interface ICountryDao {

	Country selectCountryById(int i);

	Country selectCountryById2(int i);

}
