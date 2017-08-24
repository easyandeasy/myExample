package cn.mybatis.dao;

import java.util.List;

import cn.mybatis.beans.NewsLabel;

public interface INewsLabelDao {

	//查询父栏目下所有的子栏目
	List<NewsLabel> selectChildrenByParent(int i);

	//查询父栏目及其所有了栏目
	NewsLabel selectNewsLabel(int i);

}
