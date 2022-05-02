package com.cs6083.nanoneck;

import com.cs6083.nanoneck.User.Service.UserServiceImpl;
import com.cs6083.nanoneck.User.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class NanoNeckApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {

        //System.out.println(userMapper.queryUserList());
        //userService.getUserProfile();
    }



}
