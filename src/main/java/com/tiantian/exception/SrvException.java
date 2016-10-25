package com.tiantian.exception;

public class SrvException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4312061959611304426L;
	private Integer errNo;
	private String msg;
	public SrvException() {
		super();
	}
	public SrvException(Integer errNo, String message) {
		super(message);
		this.errNo = errNo;
		this.msg = message;
	}
	public SrvException(Integer errNo, String message, Throwable cause) {
		super(message, cause);
		this.errNo = errNo;
		this.msg = message;
	}
	public SrvException(String message) {
		super(message);
		this.msg = message;
	}
	public SrvException(Throwable cause) {
		super(cause);
	}
	public Integer getErrNo() {
		return errNo;
	}
	public void setErrNo(Integer errNo) {
		this.errNo = errNo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
