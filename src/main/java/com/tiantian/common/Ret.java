package com.tiantian.common;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Ret {
	
	public static final Ret SUCC = new Ret(0,"sucess");
	public static final Ret EXCEPTION_ERROR = new Ret(998,"An exception occured!");
	public static final Ret UNKOWN_ERROR = new Ret(999,"Unknow error!");
	
	public static final Ret 用户注册成功 = new Ret(100,"用户注册成功");
	public static final Ret 用户已存在_不允许注册 = new Ret(101,"用户已存在_不允许注册");
	
	public static final Ret ERROR_CAPTCHA = new Ret(33,"验证码错误");
	

	public Integer code;
	public String msg;
	public String data;
	
	public Ret(){}

	public Ret(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Ret(Integer code) {
		this.code = code;
	}
	public Ret(Integer code, String msg,String data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	

}
