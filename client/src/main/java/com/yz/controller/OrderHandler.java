package com.yz.controller;

import com.yz.feign.OrderFeign;
import com.yz.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;
    @RequestMapping("/save/{mid}")
    public String insert(@PathVariable("mid") Long mid, HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/listAllByUid")
    @ResponseBody
    public OrderVO listAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page-1)*limit;
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderFeign.getCountByUid(user.getId()));
        orderVO.setData(orderFeign.listAllByUid(index,limit,user.getId()));
        return orderVO;
    }

    @RequestMapping("/listAllByState")
    @ResponseBody
    public OrderVO listAllByState(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderFeign.getCountByState());
        orderVO.setData(orderFeign.listAllByState(index,limit));
        return orderVO;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id){
        orderFeign.update(Long.parseLong(id));
        return "redirect:/menu/redirect/order_handler";
    }


}
