package com.cs6083.nanoneck.User.Controller;

import com.cs6083.nanoneck.User.mapper.UserMapper;
import com.cs6083.nanoneck.User.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test/user/all")
    public List<User> testGetAllUsers(){
        List<User> queryUserList = userMapper.queryUserList();
        return queryUserList;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id ){
        User user = userMapper.queryUserById(id);
        return user;
    }

    @GetMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id ){
        userMapper.deleteUser(id);
    }

}
