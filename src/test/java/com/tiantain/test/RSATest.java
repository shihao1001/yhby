package com.tiantain.test;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.tiantian.util.AES;
import com.tiantian.util.RSA;

public class RSATest {
	
	
	/*private static String privatekey  = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJAOnR+bU2Lcm2oDX8wpO7jrU7Q1UprjGyyw7loazQZPiN8AlhK/oGuDleYj9DoouI4DqRyOz8oy5XhQ4h9qJurarFbXh1einoqGgoXiTdNtQbWs7mBycIEVR3yr9oAwpOJHH1mpR+janNZjRGvRh+v2Dne1X1qspnYd2lbim8ZdAgMBAAECgYATpqqwYRPi7I0WzRcIVqea9h8Y+h0mm8xdMFWTXQySy86z/PR74kAT6oNMPaNXO67RUJaFGsYlowPCgeYWuvhL45EJeR+CPIBolEiAcOrRQPRWvNEg+B3VM3n1ZJOpfNbKhIZjIQ3ECIp63rjPOeRfbDfHCFe5gubD3CnDTQiYAQJBAO+x5XzqYuys2PcuZXT+tSSRHHMCq+81ma93Sqd+E5zpQ81IiGKEyi6t9uILDKgjkA4m077hBKnfHkmJpgaLBN0CQQCZ20H8i+hXBzJI2s59QGUTueKdO1/yBqKiqKdZi2D+ejv9a9iCLvyWNnpx4n5aqAPr0njG/pG57CV2OvF+1O+BAkEAmyd2OzOlMTp5fxcjSWYOb0sXNUNHdCIoBzKaumyb2XgNEXagAdWe4jRtmMg6OyQ5/U8YxXf2gtcQTd2yAI5AaQJAdDeKwJluB08ITL/6+eGKeDwRUXNoJgmdEAEVaC5ANflfFy4/fRbA9TZxh1Tu3MvNKnTxhl8E9MvMAGLFyGhQAQJBAIp7ACYDWu4wfsvZmYd72IpHHUqVQe1wpB2Wm0AxsOPTc/8MxqaxtTg+AosztmnAFBaYNTPzItj8SPKCjUoUgG0=";
	private static String publickey = 	"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFxX4B55uBd6umpbNkNqlViio8YEcqe2u0AeQSCuiSaq39xyWr5hBrGbWE0hlXKRoV4wE0GkxgSivQXzFYL6Tx4TuyHAx/5eBv3EHvfOYrScQ6XyEksTiSxRVxq2CYy0hAN4Cie2Z6edKxZzt0hqjH9kr2jb9ffqclsSVTBBo//wIDAQAB";	
	
	public static void main(String[] args) {
		
		try {
			String privatedata = RSA.encrypt("woshi", RSA.getPublicKey(publickey));
			System.out.println("privatedata:"+privatedata);
			String publicdata = RSA.decrypt(privatedata, RSA.getPrivateKey(privatekey));
			System.out.println("publicdata:"+publicdata);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	@Test
	public void test() throws Exception{
		String data = "我是石浩";
		String data2 = AES.encrypt(data, AES.privateKey);
		String aesKey = RSA.encrypt(AES.privateKey, RSA.PUBLIC_KEY);
		String realAesKey = RSA.decrypt(aesKey, RSA.PRIVATE_KEY);
		
		String data3 = AES.decrypt(data2, realAesKey);
		
		System.out.println("data:"+data);
		System.out.println("data2:"+data2);
		System.out.println("data3:"+data3);
		
		
		
	}

}
