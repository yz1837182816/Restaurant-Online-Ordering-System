package com.yz.mapper;

import com.yz.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    List<Menu> listAll(Integer index,Integer limit);
    Integer getCount();
    Menu getMenuById(Long id);
    void insert(Menu menu);
    void update(Menu menu);
    void deleteById(Long id);
}
