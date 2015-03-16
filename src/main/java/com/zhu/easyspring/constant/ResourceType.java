package com.zhu.easyspring.constant;

public enum ResourceType {
	Panel("panel"), Menu("menu"), Button("button");

	private String type;

	private ResourceType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}