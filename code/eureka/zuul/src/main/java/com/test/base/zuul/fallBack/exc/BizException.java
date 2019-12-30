package com.test.base.zuul.fallBack.exc;

/**
 * @Description: 业务类异常，用于控制业务逻辑
 *
 *
 * @author: renjun
 * @date: 2019年4月12日  下午2:10:35
 */
public class BizException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// 提供无参数的构造方法
	public BizException() {
		super();
	}
	
	
	public BizException(Throwable cause) {
		super(cause);
	}
	
	
	public BizException(String message) {
		super(message + "-" + ErrorType.sysError.value());
	}
	
	
	public BizException(String message, Throwable cause) {
		super(message + "-" + ErrorType.sysError.value(), cause);
	}
	
	
	public BizException(Integer code, String message) {
		super(message + "-" + code);
	}
	
	
	public BizException(Integer code, String message, Throwable cause) {
		super(message + "-" + code, cause);
	}
	
	
	public BizException(ErrorType errorType) {
		super(errorType.msg() + "-" + errorType.value());
	}
	
	
	public BizException(ErrorType errorType, Throwable cause) {
		super(errorType.msg() + "-" + errorType.value(), cause);
	}
	
	
	public BizException(ErrorType errorType, String message) {
		super(message + "-" + errorType.value());
	}
	
	
	public BizException(ErrorType errorType, String message, Throwable cause) {
		super(message + "-" + errorType.value(), cause);
	}
	
}
