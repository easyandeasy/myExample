package cn.spring.exception;

public class BuyStockException extends Exception { // �̳�exception�����ܲ��쳣

	public BuyStockException() {
		super();
	}

	public BuyStockException(String message) {
		super(message);
	}

}
