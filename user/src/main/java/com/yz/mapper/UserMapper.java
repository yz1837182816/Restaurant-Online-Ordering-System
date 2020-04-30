package com.yz.mapper;

import com.yz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> listAll(int index,int limit);
    int getCount();
    void insert(User user);
    void deleteById(Long id);
}
