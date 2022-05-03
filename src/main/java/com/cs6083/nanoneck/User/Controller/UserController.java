package com.cs6083.nanoneck.User.Controller;

import com.cs6083.nanoneck.User.Service.UserServiceImpl;
import com.cs6083.nanoneck.User.mapper.UserMapper;
import com.cs6083.nanoneck.User.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;


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
            userService.login(username, password);
            return "views/index";
         }catch (UnknownAccountException e){
            model.addAttribute("msg","unknown account");
            return "views/user/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","Wrong Username or password");
            return "views/user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "views/index";
    }

    @GetMapping("/user/profile")
    public String toProfile(Model model){
        model.addAttribute("profile",userService.getUserProfile());
        return "views/user/profile";
    }

    @GetMapping("/user/signup")
    public String tosignup(){
        return "views/user/signup";
    }

    @PostMapping("/user/signup")
    public String handle_signup_request(String email,String username,String password,String city,String state, Model model){
        try{
            userService.signup(email,username,password,city,state);
            return "redirect:/index";
        }catch (Exception e){
            model.addAttribute("msg","Duplicate username!");
            return "views/user/signup";
        }
    }

    @PostMapping("/user/profile")
    public String updateUserInfo(String state, String city, String email, String phone, Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(city);
        System.out.println(email);
        System.out.println(state);
        userService.updateUserInfo(user.getUid(),email,phone,city,state);
    return "redirect:/user/profile";
    }

}