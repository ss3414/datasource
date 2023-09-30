package com.controller;

import com.mapper.UserMapper;
import com.service.UserService;
import com.util.CustomCacheUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
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

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    /* 自定义缓存（ConcurrentHashMap+读写锁） */
    @RequestMapping("/custom")
    public Map<String, Object> custom() {
        return new LinkedHashMap<>(CustomCacheUtil.getCache());
    }

    /* fixme 一级缓存 */
    @RequestMapping("/first")
    public Map<String, Object> first() {
        userMapper.selectById(1);
        userMapper.selectById(1);
        return new LinkedHashMap<>();
    }

    /* 二级缓存 */
    @RequestMapping("/second")
    public Map<String, Object> second() {
        userService.selectOne(1);
        userService.selectOne(1);
        return new LinkedHashMap<>();
    }

    /* EhCache+加锁 */
    @RequestMapping("/ehcache")
    public Map<String, Object> ehcache() {
        Cache cache = cacheManager.getCache("user");
        System.out.println(cache.get("map").getObjectValue());
        return new LinkedHashMap<>();
    }

}
