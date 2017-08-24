package cn.spring.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.spring.dao.IAccountDao;
import cn.spring.dao.IStockDao;
import cn.spring.exception.BuyStockException;

public class BuyStockServiceImpl implements IBuyStockService {

	private IAccountDao adao;
	private IStockDao sdao;
	
	public void setAdao(IAccountDao adao) {
		this.adao = adao;
	}

	public void setSdao(IStockDao sdao) {
		this.sdao = sdao;
	}

	public void openAccount(String aname, double money) {
		adao.insertAccount(aname,money);
	}

	public void openStock(String sname, int amount) {
		sdao.insertStock(sname,amount);
	}

	public void buyStock(String aname, double money, String sname, int amount) throws BuyStockException  {
		boolean isBuy = true;
		adao.updateAccount(aname,money,isBuy);
		if (1==1) {
			throw new BuyStockException("购买股票失败");
		}
		sdao.updateStock(sname,amount,isBuy);
	}

}

