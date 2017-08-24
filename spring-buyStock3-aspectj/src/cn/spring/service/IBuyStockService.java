package cn.spring.service;

import cn.spring.exception.BuyStockException;

public interface IBuyStockService {

	public void openAccount(String aname,double money);
	public void openStock(String sname,int amount);
	
	public void buyStock(String aname,double money,String sname,int amount) throws BuyStockException;
}
