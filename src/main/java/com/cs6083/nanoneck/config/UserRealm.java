package com.cs6083.nanoneck.config;


import com.cs6083.nanoneck.User.Service.UserServiceImpl;
import com.cs6083.nanoneck.User.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	UserServiceImpl userService;

	@Override//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addStringPermission("user:add");
//		//拿到当前登录的对象
//		Subject subject = SecurityUtils.getSubject();
//		User principal = (User) subject.getPrincipal();
//
//		return info;
		return null;
	}

	@Override//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
		//Connect to AWS Database here
		User user = userService.
				queryUserByName(((UsernamePasswordToken) authenticationToken)
						.getUsername());
		// If user == null that means there is no user in our database
		if(user==null){
			return null; // throw UnknownAccountException
		}
		// The shiro will handle the password verification
		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
	}
}
