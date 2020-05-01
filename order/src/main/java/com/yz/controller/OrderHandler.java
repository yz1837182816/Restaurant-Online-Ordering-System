package com.yz.controller;

import com.yz.mapper.OrderMapper;
import com.yz.pojo.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/insert")
    public void insert(@RequestBody Order order){
        order.setDate(new Timestamp(System.currentTimeMillis()));
        orderMapper.insert(order);
    }

    @GetMapping("/listAllByUid/{index}/{limit}/{uid}")
    public List<Order> listAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") Long uid){
        return orderMapper.listAllByUid(index,limit,uid);
    }

    @GetMapping("/getCountByUid/{uid}")
    public int getCountByUid(@PathVariable("uid") Long uid){
        return orderMapper.getCountByUid(uid);
    }

    @RequestMapping("/listAllByState/{index}/{limit}")
    public List<Order> listAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return orderMapper.listAllByState(index, limit);
    }

    @GetMapping("/getCountByState")
    public int getCountByState(){
        return orderMapper.getCountByState();
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") Long id){
        orderMapper.updateState(id);
    }
}
