package com.zhu.easyspring.service;

import java.util.List;

import com.zhu.easyspring.entity.Role;

public interface RoleService {
	public Role getRoleById(Integer id);
	
	public List<Role> getRoleList(Integer[] roleIds);
}
