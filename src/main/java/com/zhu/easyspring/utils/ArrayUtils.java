package com.zhu.easyspring.utils;

public class ArrayUtils extends org.apache.commons.lang.ArrayUtils {

	public static Integer[] parse(String[] strs) {
		if (isEmpty(strs)) {
			return null;
		}
		Integer[] arr = new Integer[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		return arr;
	}
}
