package com.cs6083.nanoneck.User.Controller;

import com.cs6083.nanoneck.User.Service.UserService;
import com.cs6083.nanoneck.User.Service.UserServiceImpl;
import com.cs6083.nanoneck.User.mapper.UserMapper;
import com.cs6083.nanoneck.User.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

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

    @GetMapping("/user/add")
    public String add(){
        return "views/user/add";
    }
    @GetMapping("/user/update")
    public String update(){
        return "views/user/update";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/user/login";
    }
    @PostMapping("/user/login")
    public String login(String username, String password, Model model){
        try{
         userService.login(username, password, model);
            return "views/index";
         }catch (UnknownAccountException e){
            model.addAttribute("msg","unknown account");
            return "views/user/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","wrong username");
            return "views/user/login";
        }
    }
    @PostMapping("/logout")
    public String logout(){
        return "views/index";
    }

}