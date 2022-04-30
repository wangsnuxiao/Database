package com.cs6083.nanoneck.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


	//ShiroFilterFactoryBean
	@Bean(name="shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

    // 添加shiro的内置过滤器
    /*
    anon: 无需认证就可以访问
    authc: 必须认证了才能访问
    user: 必须拥有 记住我 功能才能用
    perms: 拥有对某个资源的权限才能访问
    role: 拥有某个角色权限才能访问
    */
		Map<String, String> filterMap = new LinkedHashMap<>();
		filterMap.put("/user/add","authc");
		filterMap.put("/user/update","authc");
		filterMap.put("test/user/*","anon");
//		filterMap.put("/user/add","authc");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
	shiroFilterFactoryBean.setLoginUrl("/toLogin");

		return shiroFilterFactoryBean;
	}

	//DefaultwebsecurityManager
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联UserRealm
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	//Create realm Object
	@Bean(name="userRealm")
	public UserRealm userRealm(){
		return new UserRealm();
	}
}
