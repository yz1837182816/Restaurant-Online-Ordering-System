package com.yz.controller;

import com.yz.feign.MenuFeign;
import com.yz.pojo.Menu;
import com.yz.pojo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientHandler {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/listAll")
    @ResponseBody
    public MenuVO listAll(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index = (page-1)*limit;
        System.out.println(menuFeign.getCount());
        System.out.println(menuFeign.listAll(index, limit));
        return new MenuVO(0,"",menuFeign.getCount(),menuFeign.listAll(index, limit));
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
}
