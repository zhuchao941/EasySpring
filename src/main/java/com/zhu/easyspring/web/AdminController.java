package com.zhu.easyspring.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhu.easyspring.entity.User;
import com.zhu.easyspring.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping("/adminIndex")
	public String adminIndex() {
		return "admin/admin_index";
	}

	@RequestMapping("/adminUser")
	public String adminUser() {
		return "admin/admin_user";
	}

	@RequestMapping("/getUserList")
	@ResponseBody
	public List<User> getUserList(User user){
		return userService.getUserList();
	}
}
