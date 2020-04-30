package com.yz.controller;

import com.yz.mapper.TypeMapper;
import com.yz.pojo.Menu;
import com.yz.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeHandler {
    @Autowired
    private TypeMapper typeMapper;

    @GetMapping("/listAll")
    public List<Type> listAll(){
        return typeMapper.listAll();
    }


}
