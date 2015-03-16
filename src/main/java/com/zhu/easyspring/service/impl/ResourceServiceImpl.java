package com.zhu.easyspring.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhu.easyspring.dao.ResourceMapper;
import com.zhu.easyspring.entity.Resource;
import com.zhu.easyspring.entity.ResourceExample;
import com.zhu.easyspring.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@javax.annotation.Resource
	private ResourceMapper resourceMapper;

	@Override
	public Resource getResourceById(Integer id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Resource> getAvaliableResources(Integer[] resourceIds) {
		ResourceExample example = new ResourceExample();
		example.createCriteria().andIdIn(Arrays.asList(resourceIds))
				.andAvaliableEqualTo(1);
		example.setOrderByClause("id");
		return resourceMapper.selectByExample(example);
	}

}