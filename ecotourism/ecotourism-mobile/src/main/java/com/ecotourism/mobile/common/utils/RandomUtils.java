package com.ecotourism.mobile.common.utils;

import java.util.Random;

/**
 * Create at 2012-07-19
 * 
 * @author Chen Mohan
 * @category 随机信息处理类
 */
public class RandomUtils {

	/**
	 * @category 生成随机字符串
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandomString(int length) {
		if (length < 2) {
			throw new RuntimeException("the length of random string must greater 2");
		}
		int num = length / 5;
		if (num == 0) {
			num = 1;
		}

		String numStr = getRandomNum(num);
		String letterStr = getRandLetter(length - num);
		return shuffle(numStr + letterStr);
	}

	/**
	 * @category 生成随机数字
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandomNum(int length) {
		String radStr = "0123456789";
		StringBuilder generateRandStr = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int randNum = rand.nextInt(radStr.length());
			generateRandStr.append(radStr, randNum, randNum + 1);
		}
		return generateRandStr.toString();
	}

	/**
	 * @category 生成随机数字
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandom16hex(int length) {
		String radStr = "0123456789abcdef";
		StringBuilder generateRandStr = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int randNum = rand.nextInt(radStr.length());
			generateRandStr.append(radStr, randNum, randNum + 1);
		}
		return generateRandStr.toString();
	}

	/**
	 * @category 随机生成符号串
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandomSymbol(int length) {
		String radStr = "\"`~!@#$%^&*()_+-={}[]|:;'<>?,./'\\";
		StringBuilder generateRandStr = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int randNum = rand.nextInt(radStr.length());
			generateRandStr.append(radStr, randNum, randNum + 1);
		}
		return generateRandStr.toString();
	}

	/**
	 * @category 随机生成字母串
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandLetter(int length) {
		String radStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder generateRandStr = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int randNum = rand.nextInt(radStr.length());
			generateRandStr.append(radStr, randNum, randNum + 1);
		}
		return generateRandStr.toString();
	}

	/**
	 * @category 随机生成字母串
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandLetterAndNum(int length) {
		String radStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder generateRandStr = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int randNum = rand.nextInt(radStr.length());
			generateRandStr.append(radStr, randNum, randNum + 1);
		}
		return generateRandStr.toString();
	}

	/**
	 * @category 随机生成8位以上包含字母,数字,符号的字符串
	 * @param length
	 *            生成后的字符串长度
	 * @return
	 */
	public static String getRandom(int length) {
		if (length < 8) {
			length = 8;
		}

		StringBuilder builder = new StringBuilder(length);

		// 随机数字
		int num = new Random().nextInt(length / 2);
		if (num == 0) {
			num = 2;
		}
		builder.append(getRandomNum(num));

		// 3个符号
		int symbol = new Random().nextInt(length / 2);
		if (symbol == 0) {
			symbol = 3;
		}
		builder.append(getRandomSymbol(symbol));

		// length-num-symbol个字母
		builder.append(getRandLetter(length - num - symbol));
		return shuffle(builder.toString());
	}

	/**
	 * @category 随机排序字符串
	 * @param str
	 * @return
	 */
	private static String shuffle(String str) {
		char[] chars = str.toCharArray();
		Random rnd = new Random();

		for (int i = chars.length; i > 1; i--) {
			swap(chars, i - 1, rnd.nextInt(i));
		}

		for (int i = chars.length; i > 1; i--) {
			swap(chars, i - 1, rnd.nextInt(i));
		}

		StringBuilder builder = new StringBuilder(chars.length);
		for (char c : chars) {
			builder.append(c);
		}
		return builder.toString();
	}

	/**
	 * Swaps the two specified elements in the specified array.
	 */
	private static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(getRandLetterAndNum(6));
	}
}
