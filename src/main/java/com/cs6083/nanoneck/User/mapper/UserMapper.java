package com.cs6083.nanoneck.User.mapper;

import com.cs6083.nanoneck.User.pojo.User;
import com.cs6083.nanoneck.User.pojo.userProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    userProfile getUserProfileByName(String username);

    userProfile getUserProfileById(int id);
    @Select(
            "select COALESCE(SUM(A.thumbs_up_num),0 ) from User left join Answers A on User.uid = A.uid\n"
                    + "        group by User.uid having User.uid=#{id};")
    int getUserLikes(int id);

  @Update("update Profile set level=#{id} where uid=#{id};")
  void updateUserLevel(int id, String level);
}
