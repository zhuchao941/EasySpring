package com.zhu.easyspring.service;

import java.util.List;
import java.util.Set;

import com.zhu.easyspring.dto.MenuBean;
import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.entity.User;

public interface UserService {
	public boolean register(User user);

	public User getUserByUsername(String username);
	
	public UserPreferences getUserPreferences(User user);
	
	public List<User> getUserList();
	
	public Set<String> getRoles(String username);
	
	public Set<String> getPermissions(String username);
	
	public List<MenuBean> getMenus(String username);
}
