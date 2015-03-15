package com.zhu.easyspring.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zhu.easyspring.entity.User;
import com.zhu.easyspring.service.UserService;

public class UserRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Override
	public String getName() {
		return "userRelam";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// null usernames are invalid
		if (principals == null) {
			throw new AuthorizationException(
					"PrincipalCollection method argument cannot be null.");
		}

		String username = (String) getAvailablePrincipal(principals);
		// 再得到role
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new AuthorizationException("No user can be found.");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(
				userService.getRoles(username));
		info.setStringPermissions(userService.getPermissions(username));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();

		// Null username is invalid
		if (username == null) {
			throw new AccountException(
					"Null usernames are not allowed by this realm.");
		}

		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UnknownAccountException("No account found for user ["
					+ username + "]");
		}

		// 此处返回plainPassword即可
		return new SimpleAuthenticationInfo(username, user.getPassword()
				.toCharArray(), getName());
	}
}
