package com.cs6083.nanoneck.User.mapper;

import com.cs6083.nanoneck.User.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //@Select("select * from User")
    List<User> queryUserList();

    //@Select("select * from User where uid = #{id}")
    User queryUserById(int id);

    User queryUserByName(String username);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
