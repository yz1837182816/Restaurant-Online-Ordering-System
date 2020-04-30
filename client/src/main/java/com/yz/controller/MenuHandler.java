package com.yz.controller;

import com.yz.feign.MenuFeign;
import com.yz.pojo.Menu;
import com.yz.pojo.MenuVO;
import com.yz.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/listAll")
    @ResponseBody
    public MenuVO listAll(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return new MenuVO(0,"",menuFeign.getCount(),menuFeign.listAll(index, limit));
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/deleteMenuById/{id}")
    public String deleteMenuById(@PathVariable("id") Long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/updateMenuById/{id}")
    public ModelAndView updateMenuById(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView();
        view.setViewName("menu_update");
        Menu menuById = menuFeign.getMenuById(id);
        List<Type> attributeValue = menuFeign.listAll();
        view.addObject("menu", menuById);
        view.addObject("list", attributeValue);
        return view;
    }
    @GetMapping("/getTypes")
    public ModelAndView getTypes(){
        ModelAndView view = new ModelAndView();
        view.setViewName("menu_add");
        view.addObject("list",menuFeign.listAll());
        return view;
    }
    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }
}
