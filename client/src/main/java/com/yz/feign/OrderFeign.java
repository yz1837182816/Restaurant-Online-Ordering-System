package com.yz.feign;

import com.yz.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "order")
public interface OrderFeign {
    @RequestMapping("/order/insert")
    void save(@RequestBody Order order);
    @GetMapping("/order/listAllByUid/{index}/{limit}/{uid}")
    List<Order> listAllByUid(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("uid") Long uid);
    @GetMapping("/order/getCountByUid/{uid}")
    int getCountByUid(@PathVariable("uid") Long uid);
    @GetMapping("/order/getCountByState")
    int getCountByState();
    @RequestMapping("/order/listAllByState/{index}/{limit}")
    List<Order> listAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit);
    @GetMapping("/order/update/{id}")
    void update(@PathVariable("id") Long id);
}
