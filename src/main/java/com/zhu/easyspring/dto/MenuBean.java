package com.zhu.easyspring.dto;

import java.util.List;

import com.zhu.easyspring.entity.Resource;

public class MenuBean {
	private Resource head;
	private List<Resource> subMenus;

	public Resource getHead() {
		return head;
	}

	public void setHead(Resource head) {
		this.head = head;
	}

	public List<Resource> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Resource> subMenus) {
		this.subMenus = subMenus;
	}

}
