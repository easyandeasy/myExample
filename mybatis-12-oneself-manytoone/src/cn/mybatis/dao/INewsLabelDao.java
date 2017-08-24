package cn.mybatis.dao;

import java.util.List;

import cn.mybatis.beans.NewsLabel;

public interface INewsLabelDao {

	//根据id查询本身及其父栏目
	NewsLabel selectNewsLabel(int i);

}
