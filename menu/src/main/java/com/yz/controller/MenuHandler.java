package com.yz.controller;

import com.yz.mapper.MenuMapper;
import com.yz.mapper.TypeMapper;
import com.yz.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;
    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/index")
    public String index(){
        return "menu的端口："+this.port;
    }
    @GetMapping("/listAll/{index}/{limit}")
    public List<Menu> listAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
       return menuMapper.listAll(index,limit);
    }
    @GetMapping("/getCount")
    public int getCount(){
        return menuMapper.getCount();
    }

    @DeleteMapping("/deleteMenuById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        menuMapper.deleteById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuMapper.insert(menu);
    }
    @GetMapping("/getMenuById/{id}")
    public Menu getMenuById(@PathVariable("id") Long id){
        return menuMapper.getMenuById(id);
    }
    @PostMapping("/update")
    public void update(@RequestBody Menu menu){
        menuMapper.update(menu);
    }
}
