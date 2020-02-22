package com.ecotourism.api.common.utils;

import com.vdurmont.emoji.EmojiParser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
	private static final String SALT = "1qazxsw2";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static String encrypt(String username, String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
		return newPassword;
	}
	public static void main(String[] args) {
		
		//System.out.println(MD5Utils.encrypt("admin", "1"));
//		String enjoj = "?��????fuasf???????????????????????????????�����������ã�?������������?���s�U�r�t�p?����.?;���䣿������������������@��??�n�j�k�����|#��$�}&��%*�~�������\�����D��??�l�m+=<��_-\\��~�h�i��������??�x�y���������ۣݡ�������{}��������������_��������硥����?????????????��??���???";
//		String enjoj2 = "\uD83D\uDE00 fsdgsdg\uD83D\uDE2C \uD83D\uDE01 \uD83D\uDE02 \uD83D\uDE03 \uD83D\uDE04 \uD83E\uDD23 \uD83D\uDE05 \uD83D\uDE06 \uD83D\uDE07 \uD83D\uDE09 \uD83D\uDE0A \uD83D\uDE42 \uD83D\uDE43 ? \uD83D\uDE0B \uD83D\uDE0C \uD83D\uDE0D \uD83D\uDE18 \uD83D\uDE17 \uD83D\uDE19 \uD83D\uDE1A \uD83E\uDD2A \uD83D\uDE1C \uD83D\uDE1D \uD83D\uDE1B \uD83E\uDD11 \uD83D\uDE0E \uD83E\uDD13 \uD83E\uDDD0 \uD83E\uDD20 \uD83E\uDD17 \uD83E\uDD21 \uD83D\uDE0F \uD83D\uDE36 \uD83D\uDE10 \uD83D\uDE11 \uD83D\uDE12 \uD83D\uDE44 ";
//		System.out.println(EmojiParser.parseToUnicode(enjoj));
//		System.out.println(EmojiParser.removeAllEmojis(enjoj2));
//		System.out.println(EmojiCharacterUtil.filter(enjoj2));
//		System.out.println(EmojiCharacterUtil.filter(enjoj));
	}

}
