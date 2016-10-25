package com.tiantian.common;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.alibaba.fastjson.JSON;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Response {
	public final static String SUCCESS;
	public final static String FAILURE;
	
	
	static {
		SUCCESS = JSON.toJSONString(new Response(Ret.SUCC.getErrno(),Ret.SUCC.getMsg()));
		FAILURE = JSON.toJSONString(new Response(Ret.UNKOWN_ERROR.getErrno(),Ret.UNKOWN_ERROR.getMsg()));
	}
	
	public Integer errno;
	public String msg;
	private String data;
	
	public Response() {
		
	}
	
    public Response(Ret ret) {
		this.errno = ret.getErrno();
		this.msg = ret.getMsg();
	}
    
    public Response(Ret ret,String data) {
		this.errno = ret.getErrno();
		this.msg = ret.getMsg();
		this.data = data;
	}
	
	public Response(Integer errno, String msg) {
		super();
		this.errno = errno;
		this.msg = msg;
	}
	
	
	public Response(Integer errno, String msg, String data) {
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
