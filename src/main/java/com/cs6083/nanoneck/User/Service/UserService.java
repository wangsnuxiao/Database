package com.cs6083.nanoneck.User.Service;

import com.cs6083.nanoneck.User.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService  {
	void login(String username, String password);
	User queryUserById(int id);
	User queryUserByName(String username);


}
