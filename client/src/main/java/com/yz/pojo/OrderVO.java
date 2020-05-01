package com.yz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private int code;
    private String msg;
    private int count;
    private List<Order> data;
}
