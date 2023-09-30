package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @RequestMapping("/curd")
    public Map curd() {
        /* 主键由雪花算法生成，对表id取余均匀存储 */
//        for (int i = 1; i <= 10; i++) {
//            userMapper.insert(User.builder().name("name" + i).build());
//        }
//        userMapper.updateById(User.builder().id(1L).name("name2").build());
//        userMapper.deleteById(1L);

        List<User> userList = userMapper.selectList(new QueryWrapper<>());
        return new LinkedHashMap();
    }

}
