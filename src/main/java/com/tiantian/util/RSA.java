package com.tiantian.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class RSA {
	
	 /** *//** 
     * 加密算法RSA 
     */  
    public static final String KEY_ALGORITHM = "RSA";  
      
    /** *//** 
     * 签名算法 
     */  
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";  
  
    /** *//** 
     * 获取公钥的key 
     */  
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOamkRfk0H1fz3k/0NGwmSN5wkph8v3NfvPZSE3tkhmNUIlLbLfZhtqRTAu1f/TLA6q8BHQXExchLQp3WZTYmnTw/jTXnP101WDv/owFpNgVsxRfkz9FYKAeEOQmfa7etfMcU0zBvJTPUgQ1Dj7nAORwOrfp2a3jV0hw0JPUxjJQIDAQAB";  
      
    /** *//** 
     * 获取私钥的key 
     */  
    public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAI5qaRF+TQfV/PeT/Q0bCZI3nCSmHy/c1+89lITe2SGY1QiUtst9mG2pFMC7V/9MsDqrwEdBcTFyEtCndZlNiadPD+NNec/XTVYO/+jAWk2BWzFF+TP0VgoB4Q5CZ9rt618xxTTMG8lM9SBDUOPucA5HA6t+nZreNXSHDQk9TGMlAgMBAAECgYAaH1CYYddVSZ3195Ih9kSiKkscuc/coqCFBIGagZnIPNVOlqCU4Lu12Z6x32s7q+BjUp+ZMlrF3AuxdBXxAbTu0lgMnUv0HMrP2dSlUr3HKHDKpuB/ZPVCw6ty4l9v/p/LXFkBbliSdWsG0JIsUZgROHM5Ca/KlKNSewCgCGQ4/QJBAMCIJIamhy4KeTbNxqNctrXQCoXdASBR8m3aDdz1+UBgYJTjyynjgD4Q/P2Z30QGRbbRRACTOjL1tAY6PZFOXI8CQQC9XPDmdY0XQci/pvXPJrw1Jt3BK/kgoBIFfP3CZTPbrLpVqJ7osEASScdo3/6EHVsXKXMUTyiAh/xWl1CfcYcLAkEAtNSqCdYLDVFE/BZVxUXlTeqyl3w1/Jc7LbYqYyicDLz4uZ8iSJum7aSjGcYWDxwdClKOnkOp3AcuKNM21G1XPQJAYQsqYdDIV6zc5mr3+gtN1KdwabjRWYju82UU3vTiWKfybkeV+IWqsDSjPvncA3TP49TYJwZSKVyHUxEEvlF99QJBALQPoVAeZWpUVJD3g1aAOlUweB7+jJirBUMoqYPFFrVLf0aM5WZv8TCJuxhucy6yk034THtyyJivGO+omOp+APY=";  
	
	public static void genKeys(){
	    KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			//SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes());
		   // keyPairGenerator.initialize(64, secureRandom);
			keyPairGenerator.initialize(1024);
		    KeyPair keyPair = keyPairGenerator.genKeyPair();
		    String privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
		    String publicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
		    System.out.println("private:"+privateKey);
		    System.out.println("public:"+publicKey);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
	
	/**
     * 转换密钥
     */
    public static Key toPublicKey(byte[] key) throws Exception{
    	KeySpec keySpec = new X509EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = factory.generatePublic(keySpec);
        return publicKey;   
    }
    
    public static Key toPrivateKey(byte[] key) throws Exception{
    	KeySpec keySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = factory.generatePrivate(keySpec);
        return privateKey;   
    }
    
    
	
	//公钥加密
	public static String encrypt(String data,String key){
        Cipher cipher;
		try {
			cipher = Cipher.getInstance("RSA");
			PublicKey publicKey = (PublicKey) toPublicKey(Base64.decodeBase64(key));
		    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		    byte[] cipherText = cipher.doFinal(data.getBytes());
		    return Base64.encodeBase64String(cipherText);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return "";   
	}
	
	
	
	//公钥加密
		public static byte[] encrypt2(String data,String key){
	        Cipher cipher;
			try {
				cipher = Cipher.getInstance("RSA");
				PublicKey publicKey = (PublicKey) toPublicKey(Base64.decodeBase64(key));
			    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			    byte[] cipherText = cipher.doFinal(data.getBytes());
			    return Base64.encodeBase64(cipherText);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			return null;   
		}
	
	
	//私钥解密
	public static String decrypt(String data,String key){
		try {
			PrivateKey privateKey = (PrivateKey) toPrivateKey(Base64.decodeBase64(key));
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decryptedMsg = cipher.doFinal(data.getBytes());
			return Base64.encodeBase64String(decryptedMsg);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	//私钥解密
		public static byte[] decrypt2(String data,String key){
			try {
				PrivateKey privateKey = (PrivateKey) toPrivateKey(Base64.decodeBase64(key));
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				byte[] decryptedMsg = cipher.doFinal(data.getBytes());
				return Base64.encodeBase64(decryptedMsg);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	
	 /** *//** 
     * <p> 
     * 用私钥对信息生成数字签名 
     * </p> 
     *  
     * @param data 已加密数据 
     * @param privateKey 私钥(BASE64编码) 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String sign(byte[] data, String privateKey) throws Exception {  
    	
        byte[] keyBytes = Base64.decodeBase64(privateKey);  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initSign(privateK);  
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }  
    
    /** *//** 
     * <p> 
     * 校验数字签名 
     * </p> 
     *  
     * @param data 已加密数据 
     * @param publicKey 公钥(BASE64编码) 
     * @param sign 数字签名 
     *  
     * @return 
     * @throws Exception 
     *  
     */  
    public static boolean verify(byte[] data, String publicKey, String sign)  
            throws Exception {  
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        PublicKey publicK = keyFactory.generatePublic(keySpec);  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initVerify(publicK);  
        signature.update(data);  
        return signature.verify(Base64.decodeBase64(sign));
    }  
    
    
 public static void main(String[] args) {
	//genKeys();
	 String data = "12";
	 String enData = encrypt(data, PUBLIC_KEY);
	 System.out.println("enData:"+enData);
	 String data2 = decrypt(enData, PRIVATE_KEY);
	 System.out.println("data2:"+data2);
}

}
