package com.yz.feign;

import com.yz.pojo.Menu;
import com.yz.pojo.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/listAll/{page}/{limit}")
    List<Menu> listAll(@PathVariable("page") int page,@PathVariable("limit") int limit);
    @GetMapping("/menu/getCount")
    int getCount();
    @DeleteMapping("/menu/deleteMenuById/{id}")
    void deleteById(@PathVariable("id") Long id);
    @GetMapping("/type/listAll")
    List<Type> listAll();
    @PostMapping("/menu/save")
    void save(Menu menu);
    @PostMapping("/menu/update")
    void update(Menu menu);
    @GetMapping("/menu/getMenuById/{id}")
    Menu getMenuById(@PathVariable("id") Long id);
}
