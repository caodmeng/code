package com.test.base.zuul.fallBack.exc;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 *
 * 错误信息封装
 *
 * @author  caodm3
 * @date: 2019/8/15   0:28
 */
@Data
public class ErrorInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	private String message;
	
	private String timestamp;
	
	private String error;
	
	private String path;
	
	public ErrorInfo() {
		this.status  = ErrorType.success.value();
		this.message = ErrorType.success.msg();
	} 
	
	public ErrorInfo(ErrorType errortype) {
		this.status  = errortype.value();
		this.message = errortype.msg();
	}

	public void setErrorInfo(ErrorType errortype) {
		this.status  = errortype.value();
		this.message = errortype.msg();
	}
}
