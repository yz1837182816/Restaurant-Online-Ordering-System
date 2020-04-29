package com.yz.controller;

import com.yz.mapper.MenuMapper;
import com.yz.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "menu的端口："+this.port;
    }

    @Autowired
    private MenuMapper menuMapper;
    @GetMapping("/listAll/{index}/{limit}")
    public List<Menu> listAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
       return menuMapper.listAll(index,limit);
    }
    @GetMapping("/getCount")
    public int getCount(){
        return menuMapper.getCount();
    }
}
