package com.yz.controller;

import com.yz.mapper.AdminMapper;
import com.yz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Object object = null;
        switch (type){
            case "user":
                object = userMapper.login(username,password);
                break;
            case "admin":
                object = adminMapper.login(username,password);
                break;
            default:
                throw new RuntimeException("登录状态错误");
        }
        return object;
    }
}
