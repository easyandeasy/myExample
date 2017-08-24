package com.jdbc.impl;

import com.jdbc.baseDao.BaseDao;

/**
 * 鐢ㄦ埛瀹炵幇绫�
 * @author tang
 *
 */
public class NewsUserImpl extends BaseDao {

	/**
	 * 閫夋嫨澧炪�鍒犮�鏀规搷浣�
	 * @param name 鐢ㄦ埛鍚�
	 * @param pwd 瀵嗙爜
	 * @return 杩斿洖鍙楀奖鍝嶇殑琛屾暟
	 */
	public int insert(String name , String pwd){
		int row = 0;
		String sql = "insert into admin(name,pwd) values(?,?)";
		Object[] obj = {name,pwd};
		row = executeUpdateSQL(sql,obj);
		closeAllSQL();
		return row;
	}
}
