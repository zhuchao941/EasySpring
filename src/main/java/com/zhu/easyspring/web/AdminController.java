package com.zhu.easyspring.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhu.easyspring.dto.MenuBean;
import com.zhu.easyspring.dto.UserPreferences;
import com.zhu.easyspring.entity.User;
import com.zhu.easyspring.service.UserService;
import com.zhu.easyspring.velocity.bean.Datagrid;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@javax.annotation.Resource
	private UserService userService;

	@RequestMapping("/adminIndex")
	public String adminIndex(HttpSession session, Model model) {
		UserPreferences userPreferences = getUserPreferences(session);
		List<MenuBean> menus = userService.getMenus(userPreferences
				.getUsername());
		model.addAttribute("menus", menus);
		return "admin/admin_index";
	}

	@RequiresRoles("admin")
	@RequestMapping("/adminUser")
	public String adminUser(Model model) {
		model.addAttribute("datagrid", new Datagrid());
		return "admin/admin_test";
	}

	@RequestMapping("/getUserList")
	@ResponseBody
	public List<User> getUserList(User user) {
		return userService.getUserList();
	}
}
