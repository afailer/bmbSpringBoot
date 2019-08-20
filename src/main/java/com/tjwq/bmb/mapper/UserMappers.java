package com.tjwq.bmb.mapper;

import com.tjwq.bmb.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMappers {

    @Select("select * from users where phone_num = #{phone_num}")
    List<User> findUserByMobbile(String phone_num);

    @Insert("insert into users (phone_num , password, user_level, email, user_name, wechat_id, sex, iccard_num) values" +
            "#{user.}")
    Void addUser(User user);

}
