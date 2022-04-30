package com.cs6083.nanoneck.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class UserRealm extends AuthorizingRealm {

	@Override//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		return null;
	}

	@Override//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String name = "root";
		String password = "123456";

		UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

		if(!userToken.getUsername().equals(name)){
			return null; // throw UnknownAccountException
		}
		// The shiro will handel the passwrod verification
		return new SimpleAuthenticationInfo("",password,"");
	}
}
