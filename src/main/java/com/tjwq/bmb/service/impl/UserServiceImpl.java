package com.tjwq.bmb.service.impl;

import com.tjwq.bmb.entity.User;
import com.tjwq.bmb.mapper.UserMappers;
import com.tjwq.bmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMappers userMappers;

    @Override
    public User findUserByMobile(String mobile) {
        System.out.println(mobile);
        List<User> users = userMappers.findUserByMobbile(mobile);
        if (users.size() != 0){
            return users.get(0);
        }else{
            return null;
        }
    }

}
