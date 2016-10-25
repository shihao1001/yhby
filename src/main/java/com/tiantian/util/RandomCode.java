package com.tiantian.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomCode{
		public String code;
		private long expir_time;
		
		
		private RandomCode(){
			this.code = RandomStringUtils.randomAlphanumeric(4);
			this.expir_time = System.currentTimeMillis()+3000*1000;//有效时间50分钟
		}
		
		public static RandomCode genCode(){
			return new RandomCode();
		}
		
		public boolean isExpired(){
			return System.currentTimeMillis()>this.expir_time;
		}
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public long getExpir_time() {
			return expir_time;
		}
		public void setExpir_time(long expir_time) {
			this.expir_time = expir_time;
		}
	}