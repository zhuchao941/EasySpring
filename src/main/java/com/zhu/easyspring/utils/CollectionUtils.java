package com.zhu.easyspring.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class CollectionUtils extends
		org.apache.commons.collections.CollectionUtils {

	@SuppressWarnings("rawtypes")
	public static Map parseMap(List list, String key) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (list != null) {
			for (Object obj : list) {
				try {
					map.put(BeanUtils.getProperty(obj, key), obj);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map group(List list, String groupKey) {
		Map<Object, List> groupListMap = new HashMap<Object, List>();
		if (list != null) {
			for (Object obj : list) {
				Object groupValue = null;
				try {
					groupValue = BeanUtils.getProperty(obj, groupKey);
				} catch (Exception e) {
					e.printStackTrace();
				}
				List groupList = groupListMap.get(groupValue);
				if (groupList == null) {
					groupList = new ArrayList();
					groupListMap.put(groupValue, groupList);
				}
				groupList.add(obj);
			}
		}
		return groupListMap;
	}
}
