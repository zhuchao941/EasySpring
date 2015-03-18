package com.zhu.easyspring.service;

import java.util.List;

import com.zhu.easyspring.entity.Resource;
import com.zhu.easyspring.velocity.bean.DatagridData;

public interface ResourceService {
	
	public Resource getResourceById(Integer id);
	
	public List<Resource> getAvaliableResources(Integer[] resourceIds);
	
	public DatagridData getResourceTree();
}
