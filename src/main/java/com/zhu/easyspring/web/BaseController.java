package com.zhu.easyspring.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

	@ModelAttribute("contextPath")
	protected String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

}
