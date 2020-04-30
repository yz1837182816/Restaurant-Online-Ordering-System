package com.yz.feign;

import com.yz.pojo.Menu;
import com.yz.pojo.Type;
import com.yz.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {
    @GetMapping("/user/listAll/{page}/{limit}")
    List<User> listAll(@PathVariable("page") int page, @PathVariable("limit") int limit);
    @GetMapping("/user/getCount")
    int getCount();
    @DeleteMapping("/user/deleteUserById/{id}")
    void deleteById(@PathVariable("id") Long id);
    @PostMapping("/user/save")
    void save(User user);
    @GetMapping("/user/getUserById/{id}")
    User getUserById(@PathVariable("id") Long id);
}
