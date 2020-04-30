package com.yz.controller;

import com.yz.feign.AccountFeign;
import com.yz.pojo.Admin;
import com.yz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object o = accountFeign.login(username, password, type);
        LinkedHashMap map= (LinkedHashMap<String,Object>) o;
        String result = null;
        if(o==null){
            result = "login";
        }else {
            switch (type){
                case "user":
                    User user = new User();
                    Long id = Long.parseLong(String.valueOf(map.get("id")));
                    String nickname = String.valueOf(map.get("nickname"));
                    session.setAttribute("user",user);
                    result = "redirect:/account/redirect/index";
                    break;
                case "admin":
                    Admin admin = (Admin) o;
                    session.setAttribute("admin",admin);
                    result = "redirect:/account/redirect/main";
                    break;
                default:
            }
        }
        return result;
    }

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }
}
