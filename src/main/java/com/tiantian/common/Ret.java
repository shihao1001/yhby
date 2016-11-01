package com.tiantian.common;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Ret {
	
	public static final Ret SUCC = new Ret(0,"sucess");
	public static final Ret EXCEPTION_ERROR = new Ret(998,"An exception occured!");
	public static final Ret UNKOWN_ERROR = new Ret(999,"Unknow error!");
	
	public static final Ret 用户注册成功 = new Ret(100,"用户注册成功");
	public static final Ret 用户已存在_不允许注册 = new Ret(101,"用户已存在,不允许注册");
	public static final Ret 用户不存在_请先注册再登录 = new Ret(102,"用户不存在，请先注册再登录");
	public static final Ret 用户或者密码不正确 = new Ret(103,"用户或者密码不正确");
	public static final Ret 请先登录 = new Ret(104,"请先登录");
	
	
	public static final Ret ERROR_CAPTCHA = new Ret(33,"验证码错误");
	

	public Integer errno;
	public String msg;
	public String data;
	
	public Ret(){}

	public Ret(Integer errno, String msg) {
		super();
		this.errno = errno;
		this.msg = msg;
	}

	public Ret(Integer errno) {
		this.errno = errno;
	}
	public Ret(Integer errno, String msg,String data) {
		super();
		this.errno = errno;
		this.msg = msg;
		this.data = data;
	}

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

}
