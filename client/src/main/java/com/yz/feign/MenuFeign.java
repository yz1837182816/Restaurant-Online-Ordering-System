package com.yz.feign;

import com.yz.pojo.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/listAll/{page}/{limit}")
    List<Menu> listAll(@PathVariable("page") int page,@PathVariable("limit") int limit);
    @GetMapping("/menu/getCount")
    int getCount();
}
