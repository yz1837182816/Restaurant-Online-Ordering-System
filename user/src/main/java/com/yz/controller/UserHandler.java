package com.yz.controller;


import com.yz.mapper.UserMapper;
import com.yz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Value("${server.port}")
    private String port;
    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/listAll/{index}/{limit}")
    public List<User> listAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return userMapper.listAll(index,limit);
    }
    @GetMapping("/getCount")
    public int getCount(){
        return userMapper.getCount();
    }
    @DeleteMapping("/deleteUserById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userMapper.deleteById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Timestamp(System.currentTimeMillis()));
        userMapper.insert(user);
    }
}
