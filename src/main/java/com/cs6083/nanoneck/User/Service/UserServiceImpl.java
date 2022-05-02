package com.cs6083.nanoneck.User.Service;

import com.cs6083.nanoneck.User.mapper.UserMapper;
import com.cs6083.nanoneck.User.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	public void login(String username, String password) throws UnknownAccountException {
		//Get current user subject
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		subject.login(token);
	}

	public void signup(String email,String username,String password,String city,String state )
			throws Exception {
		User newUser = new User(0,username,password,email,city,state);
		// perform duplication check
		User exist = userMapper.queryUserByName(username);
		if (exist!=null){
			throw  new Exception("Duplicate username!");
		}
		userMapper.addUser(newUser);
		login(username,password);
	}

	public void logout(){
		SecurityUtils.getSubject().logout();
	}

	@Override
	public User queryUserById(int id) {
		return userMapper.queryUserById(id);
	}

	@Override
	public User queryUserByName(String username) {
		return userMapper.queryUserByName(username);
	}

}
