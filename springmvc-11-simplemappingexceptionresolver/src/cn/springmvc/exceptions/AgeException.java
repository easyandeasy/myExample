package cn.springmvc.exceptions;

public class AgeException extends StudentException {

	public AgeException() {
		super();
	}

	public AgeException(String message) {
		super(message);
	}
}
