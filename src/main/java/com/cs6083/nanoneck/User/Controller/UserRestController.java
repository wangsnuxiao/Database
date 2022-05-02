package com.cs6083.nanoneck.User.Controller;

import com.cs6083.nanoneck.User.Service.UserAsyncService;
import com.cs6083.nanoneck.User.mapper.UserMapper;
import com.cs6083.nanoneck.User.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
	@Autowired
	UserMapper userMapper;


	@GetMapping("/test/user/all")
	public List<User> testGetAllUsers(){
		return userMapper.queryUserList();
	}
}
