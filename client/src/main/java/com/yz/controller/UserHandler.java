package com.yz.controller;

import com.yz.pojo.MenuVO;
import com.yz.pojo.User;
import com.yz.pojo.UserVO;
import com.yz.feign.OrderFeign;
import com.yz.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;
    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/listAll")
    @ResponseBody
    public UserVO listAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return new UserVO(0,"",userFeign.getCount(),userFeign.listAll(index, limit));
    }

    @PostMapping("/save")
    public String save(User user){
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id){
        //orderFeign.deleteByUid(id);
        System.out.println(id);
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}