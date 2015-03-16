package com.zhu.easyspring.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhu.easyspring.dao.RoleMapper;
import com.zhu.easyspring.entity.Role;
import com.zhu.easyspring.entity.RoleExample;
import com.zhu.easyspring.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public Role getRoleById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> getRoleList(Integer[] roleIds) {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdIn(Arrays.asList(roleIds));
		example.setOrderByClause("id");
		return roleMapper.selectByExample(example);
	}

	@Override
	public List<Role> getRoleList() {
		return roleMapper.selectByExample(new RoleExample());
	}

}
