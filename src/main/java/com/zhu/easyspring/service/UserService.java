package com.zhu.easyspring.service;

import java.util.List;

import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.entity.User;

public interface UserService {
	public boolean register(User user);

	public User getUserByUsername(String username);
	
	public UserPreferences getUserPreferences(User user);
	
	public List<User> getUserList();
}
