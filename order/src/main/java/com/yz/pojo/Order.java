package com.yz.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private Integer state;
}