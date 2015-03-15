package com.zhu.easyspring.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.stereotype.Service;

import com.zhu.easyspring.dao.UserMapper;
import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.entity.Role;
import com.zhu.easyspring.entity.User;
import com.zhu.easyspring.entity.UserExample;
import com.zhu.easyspring.service.RoleService;
import com.zhu.easyspring.service.UserService;
import com.zhu.easyspring.utils.StringUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private PasswordService passwordService;

	@Resource
	private RoleService roleService;

	@Override
	public boolean register(User user) {
		user.setPassword(passwordService.encryptPassword(user.getPassword()));
		return userMapper.insertSelective(user) > 0;
	}

	@Override
	public User getUserByUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> userList = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(userList)) {
			return null;
		}
		return userList.get(0);
	}

	@Override
	public UserPreferences getUserPreferences(User user) {
		UserPreferences preferences = new UserPreferences();
		preferences.setUsername(user.getUsername());
		return preferences;
	}

	@Override
	public List<User> getUserList() {
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public Set<String> getRoles(String username) {
		User user = getUserByUsername(username);
		if (user == null || StringUtils.isEmpty(user.getRoleIds())) {
			return null;
		}
		Set<String> roles = null;
		Integer[] ids = Arrays.asList(user.getRoleIds().split(",")).toArray(
				new Integer[0]);
		for (Integer id : ids) {
			Role role = roleService.getRoleById(id);
			if (roles == null) {
				roles = new HashSet<String>();
				roles.add(role.getName());
			}
		}
		return roles;
	}

	@Override
	public Set<String> getPermissions(String username) {
		User user = getUserByUsername(username);
		if (user == null || StringUtils.isEmpty(user.getRoleIds())) {
			return null;
		}
		Set<String> permissions = null;
		Integer[] ids = Arrays.asList(user.getRoleIds().split(",")).toArray(
				new Integer[0]);
		for (Integer id : ids) {
			Role role = roleService.getRoleById(id);
			if (StringUtils.isNotEmpty(role.getPermissionIds())) {
				if (permissions == null) {
					permissions = new HashSet<String>();
				}
				permissions.addAll(Arrays.asList(role.getPermissionIds().split(
						",")));
			}
		}
		return permissions;
	}

}
