package com.yz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "account")
public interface AccountFeign {
    @PostMapping("/account/login/{username}/{password}/{type}")
    Object login(@PathVariable String username,@PathVariable String password,@PathVariable String type);
}
