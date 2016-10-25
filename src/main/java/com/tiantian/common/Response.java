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
		SUCCESS = JSON.toJSONString(new Response(Ret.SUCC));
		FAILURE = JSON.toJSONString(new Response(Ret.UNKOWN_ERROR));
	}
	
	private Ret ret;
	private String data;
	private String cookies;
	
	
	public Response(Ret ret) {
		this.ret = ret;
	}
	public Response(Ret ret, String data, String cookies) {
		this.ret = ret;
		this.data = data;
		this.cookies = cookies;
	}
	public Response(Ret ret, String data) {
		this.ret = ret;
		this.data = data;
		this.cookies = "";
	}

}
