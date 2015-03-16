package com.zhu.easyspring.utils;

public class ReflectionUtils extends org.springframework.util.ReflectionUtils {

	public static String getInstanceName(Class<?> clazz) {
		return StringUtils.lowerFirst(clazz.getSimpleName());
	}

}
