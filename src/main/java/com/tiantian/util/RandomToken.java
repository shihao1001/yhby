package com.tiantian.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomToken{
		public String token;
		public String secret ="xxxxxx";
		private long expir_time = 365*24*60*60*1000;
		
		
		private RandomToken(){
			this.token = RandomStringUtils.randomAlphanumeric(16)+System.currentTimeMillis()/1000;
			this.secret = RandomStringUtils.randomAlphanumeric(16);
		}
		
		public static RandomToken genToken(){
			return new RandomToken();
		}
		
		public boolean isExpired(){
			return System.currentTimeMillis()>this.expir_time;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getSecret() {
			return secret;
		}

		public void setSecret(String secret) {
			this.secret = secret;
		}

		public long getExpir_time() {
			return expir_time;
		}

		public void setExpir_time(long expir_time) {
			this.expir_time = expir_time;
		}
		
	}