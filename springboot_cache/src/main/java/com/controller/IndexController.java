package com.controller;

import com.mapper.UserMapper;
import com.model.User;
import com.util.CustomCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
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

    /* 自定义缓存（ConcurrentHashMap+读写锁） */
    @RequestMapping("/custom")
    public Map<String, Object> custom() {
        return new LinkedHashMap<>(CustomCacheUtil.getCache());
    }

    /* 缓存 */
    @RequestMapping("/select")
    public String select() {
        User user = userMapper.selectById(1);
        return user.toString();
    }

    @RequestMapping("/update")
    public Map<String, Object> update() {
        userMapper.updateById(User.builder().id(1).name("name123").password("pwd").build());
        return new LinkedHashMap<>();
    }

    @RequestMapping("/delete")
    public Map<String, Object> delete() {
        userMapper.deleteById(2);
        return new LinkedHashMap<>();
    }

}
