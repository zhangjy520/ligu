package cc.ligu.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {

	/**
	 * @Description 字符串加密为MD5 中文加密一致通用,必须转码处理： plainText.getBytes("UTF-8")
	 * @param plainText
	 *            需要加密的字符串
	 * @return
	 */
	public static String toMD5(String plainText) {
		//确定计算方法
        MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr;
			newstr = base64en.encode(md5.digest(plainText.getBytes("utf-8")));
	        return newstr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(toMD5("123456"));
	}
}
