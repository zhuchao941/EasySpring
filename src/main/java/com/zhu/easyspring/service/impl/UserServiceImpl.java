package com.zhu.easyspring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.stereotype.Service;

import com.zhu.easyspring.dao.UserMapper;
import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.entity.User;
import com.zhu.easyspring.entity.UserExample;
import com.zhu.easyspring.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private PasswordService passwordService;

	@Override
	public boolean register(User user) {
		user.setPassword(passwordService.encryptPassword(user.getPassword()));
		return userMapper.insertSelective(user) > 0;
	}

	@Override
	public User getUserByUsername(String username) {
		return userMapper.selectByPrimaryKey(username);
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

}
