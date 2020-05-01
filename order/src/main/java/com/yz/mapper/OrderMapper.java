package com.yz.mapper;

import com.yz.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    void insert(Order order);
    List<Order> listAllByUid(int index,int limit,Long uid);
    int getCountByUid(Long uid);
    List<Order> listAllByState(int index,int limit);
    void updateState(Long id);
    int getCountByState();
}
