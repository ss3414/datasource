package com.mapper;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

}
