package com.zhu.easyspring.velocity.bean;

import java.util.ArrayList;
import java.util.List;

public class ToolBar {

	private String id;

	private List<Button> btns = new ArrayList<Button>();

	public String getId() {
		return id;
	}

	public ToolBar setId(String id) {
		this.id = id;
		return this;
	}

	public List<Button> getBtns() {
		return btns;
	}

	public ToolBar setBtns(List<Button> btns) {
		this.btns = btns;
		return this;
	}

	public ToolBar addBtn(String text, String dataoptions, String fun) {
		Button button = new Button();
		button.setText(text);
		button.setDataoptions(dataoptions);
		button.setFun(fun);
		btns.add(button);
		return this;
	}

	@Override
	public String toString() {
		return null;
	}

}
