package com.zhu.easyspring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.stereotype.Service;

import com.zhu.easyspring.constant.ResourceType;
import com.zhu.easyspring.dao.UserMapper;
import com.zhu.easyspring.dto.MenuBean;
import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.entity.Resource;
import com.zhu.easyspring.entity.Role;
import com.zhu.easyspring.entity.User;
import com.zhu.easyspring.entity.UserExample;
import com.zhu.easyspring.service.ResourceService;
import com.zhu.easyspring.service.RoleService;
import com.zhu.easyspring.service.UserService;
import com.zhu.easyspring.utils.ArrayUtils;
import com.zhu.easyspring.utils.CollectionUtils;
import com.zhu.easyspring.utils.StringUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@javax.annotation.Resource
	private UserMapper userMapper;

	@javax.annotation.Resource
	private PasswordService passwordService;

	@javax.annotation.Resource
	private RoleService roleService;

	@javax.annotation.Resource
	private ResourceService resourceService;

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
		Integer[] ids = ArrayUtils.parse(user.getRoleIds().split(","));
		for (Integer id : ids) {
			Role role = roleService.getRoleById(id);
			if (roles == null) {
				roles = new HashSet<String>();
				roles.add(role.getCode());
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
		Integer[] ids = ArrayUtils.parse(user.getRoleIds().split(","));
		for (Integer id : ids) {
			Role role = roleService.getRoleById(id);
			if (StringUtils.isNotEmpty(role.getPermissionIds())) {
				if (permissions == null) {
					permissions = new HashSet<String>();
				}
				Integer[] permissionIds = ArrayUtils.parse(role
						.getPermissionIds().split(","));
				for (Integer permissionId : permissionIds) {
					Resource resource = resourceService
							.getResourceById(permissionId);
					permissions.add(resource.getCode());
				}
			}
		}
		return permissions;
	}

	@Override
	public List<MenuBean> getMenus(String username) {
		User user = getUserByUsername(username);
		if (user == null || StringUtils.isEmpty(user.getRoleIds())) {
			return null;
		}
		List<MenuBean> menus = null;
		Map<Integer, MenuBean> menusMap = new HashMap<Integer, MenuBean>();
		Integer[] roleIds = ArrayUtils.parse(user.getRoleIds().split(","));
		List<Role> roles = roleService.getRoleList(roleIds);
		for (Role role : roles) { // role
			if (StringUtils.isNotEmpty(role.getPermissionIds())) {
				Integer[] permissionIds = ArrayUtils.parse(role
						.getPermissionIds().split(","));
				List<Resource> resources = resourceService
						.getAvaliableResources(permissionIds);
				for (Resource resource : resources) { // permission
					if (resource.getType()
							.equals(ResourceType.Panel.toString())) {
						if (menus == null) {
							menus = new ArrayList<MenuBean>();
						}
						MenuBean menuBean = new MenuBean();
						menuBean.setHead(resource);
						menusMap.put(resource.getId(), menuBean);
						menus.add(menuBean);
					} else if (resource.getType().equals(
							ResourceType.Menu.toString())) {
						MenuBean menu = menusMap.get(resource.getParent());
						if (menu == null) {
							continue;
						}
						if (menu.getSubMenus() == null) {
							menu.setSubMenus(new ArrayList<Resource>());
						}
						menu.getSubMenus().add(resource);
					}
				}
			}
		}
		return menus;
	}

	@Override
	public List<Role> getRoleList() {
		return roleService.getRoleList();
	}

}
