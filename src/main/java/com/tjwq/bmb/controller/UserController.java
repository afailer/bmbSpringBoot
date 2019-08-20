package com.tjwq.bmb.controller;

import com.tjwq.bmb.entity.User;
import com.tjwq.bmb.service.UserService;
import com.tjwq.bmb.utils.JsonData;
import com.tjwq.bmb.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public Object testUser(String abc)
    {
        System.out.println("=====test=====");
        return "hello"+abc;
    }

    @PostMapping(value = "/login")
    public Object findUser(@RequestBody User user){
        System.out.println(user.toString());
        User targetUser = userService.findUserByMobile(user.getPhone_num());
        if(targetUser != null){
            String token = JwtUtils.geneJsonWebToken(targetUser);
            return JsonData.buildSuccess(token);
        }else{
            return JsonData.buildError("不存在此电话");
        }
    }

}
