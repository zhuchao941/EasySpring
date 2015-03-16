package com.zhu.easyspring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.velocity.bean.Datagrid;

@Controller
public class BaseController {

	@ModelAttribute("contextPath")
	protected String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@ModelAttribute("datagrid")
	protected Datagrid datagrid(HttpServletRequest request) {
		return new Datagrid();
	}

	protected UserPreferences getUserPreferences(HttpSession session) {
		return (UserPreferences)session.getAttribute("userPreferences");
	}
}
