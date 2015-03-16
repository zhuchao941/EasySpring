package com.zhu.easyspring.velocity.bean;

import java.util.ArrayList;
import java.util.List;

public class Datagrid {
	private String prefix; // 关键字
	private String title; // datagrid标题
	private String dataoptions;
	private List<Field> fields;

	public String getPrefix() {
		return prefix;
	}

	public Datagrid setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Datagrid setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDataoptions() {
		return dataoptions;
	}

	public Datagrid setDataoptions(String dataoptions) {
		this.dataoptions = dataoptions;
		return this;
	}

	public List<Field> getFields() {
		return fields;
	}

	public Datagrid setFields(List<Field> fields) {
		this.fields = fields;
		return this;
	}

	public Datagrid addField(String text, String dataoptions) {
		Field field = new Field();
		field.setText(text);
		field.setDataoptions(dataoptions);
		if (getFields() == null) {
			setFields(new ArrayList<Field>());
		}
		getFields().add(field);
		return this;
	}

}
