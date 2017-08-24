package cn.mybatis.dao;

import cn.mybatis.beans.Minister;

public interface IMinisterDao {

	Minister selectMinisterById(int i);

	Minister selectMinisterById2(int i);

}
