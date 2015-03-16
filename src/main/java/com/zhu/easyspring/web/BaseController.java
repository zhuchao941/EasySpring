package com.zhu.easyspring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zhu.easyspring.dto.UserPreferences;

@Controller
public class BaseController {

	@ModelAttribute("contextPath")
	protected String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	protected UserPreferences getUserPreferences(HttpSession session) {
		return (UserPreferences)session.getAttribute("userPreferences");
	}
}
