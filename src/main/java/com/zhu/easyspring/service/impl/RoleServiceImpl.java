package com.zhu.easyspring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhu.easyspring.dao.RoleMapper;
import com.zhu.easyspring.entity.Role;
import com.zhu.easyspring.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public Role getRoleById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

}
