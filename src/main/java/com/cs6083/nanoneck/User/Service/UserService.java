package com.cs6083.nanoneck.User.Service;

import com.cs6083.nanoneck.User.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface UserService  {
	void login(String username, String password, Model model);
	User queryUserById(int id);
	User queryUserByName(String username);


}
