package com.yz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private Integer state;
}
