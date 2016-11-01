package com.tiantian.common;

import com.alibaba.fastjson.JSON;

public class ResponseUtils {
	
	public static Response succ(Object obj){
		return new Response(Ret.SUCC,JSON.toJSONString(obj));
	}
	
	public static Response instance(int status,Object obj){
		return new Response(new Ret(status),JSON.toJSONString(obj)); 
	}
	
	public static Response instance(int status,String msg){
		return new Response(new Ret(status,msg));
	}	
	
	public static Response instance(int status,String msg,Object obj){
		return new Response(new Ret(status,msg),obj != null ? JSON.toJSONString(obj) : null);
	}	

}
