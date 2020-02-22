package com.ecotourism.api.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 说明：MD5处理
 * 创建人：FH Q313596790
 * 修改时间：2014年9月20日
 * @version
 */
public class MD5 {

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis()+Tools.getRandomString(4));
		for (int i = 0; i <1 ; i++) {
			String s= UUID.randomUUID().toString()+System.currentTimeMillis()+System.nanoTime();
			//先进行MD5加密
			MessageDigest md=MessageDigest.getInstance("md5");
			//对数据进行加密
			byte[] bs=md.digest(s.getBytes());
			//采用数据指纹进一步加密，拿到的数据成为数据指纹
//			BASE64Encoder base=new BASE64Encoder();
			String digitFingerprint=Base64.encodeBase64String(bs);
			System.out.println(digitFingerprint);
			/*byte[] encrypted1 = new BASE64Decoder().decodeBuffer(text);
    byte[] encrypted1 =Base64.decodeBase64(text);   */
		}

	}
}
