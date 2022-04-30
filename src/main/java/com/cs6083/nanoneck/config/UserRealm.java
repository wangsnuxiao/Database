package com.cs6083.nanoneck.config;

import com.cs6083.nanoneck.User.Service.UserService;
import com.cs6083.nanoneck.User.Service.UserServiceImpl;
import com.cs6083.nanoneck.User.pojo.User;
import org.apache.shiro.SecurityUtils;
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

		return null;
	}

	@Override//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
		//Connect to AWS Database here
		User user = userService.
				queryUserByName(((UsernamePasswordToken) authenticationToken)
						.getUsername());

		if(user==null){
			return null; // throw UnknownAccountException
		}
		// The shiro will handel the passwrod verification
		return new SimpleAuthenticationInfo("",user.getPassword(),"");
	}
}
