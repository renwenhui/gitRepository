package com.ts.app.sys.exception;

/**
 * @ClassName: CustomException
 * @Description: 自定义异常
 * @author: chunyu.xia
 * @date: 2017-11-15 上午11:46:34
 */
public class CustomException extends Exception {
	
	private String message;

	public CustomException(String message){
		super(message);
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
