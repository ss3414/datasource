package com.controller;

import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {

    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public ModelAndView user() {
        logger.info("user");

        ModelAndView view = new ModelAndView();
        User user = userMapper.selectByPrimaryKey(1);
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    @ResponseBody
    @RequestMapping("/userPage")
    public Map<String, Object> userPage(@RequestParam(defaultValue = "1") Integer currentPage) {
        /* PageHelper分页插件 */
        PageHelper.startPage(currentPage, 2);
        List<User> userList = userMapper.selectAll();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("userList", userList);
        return map;
    }

    /* 缓存 */
    @ResponseBody
    @RequestMapping("/cache")
    public Map<String, Object> cache() {
        List<User> userList = userMapper.selectAll();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("userList", userList);
        return map;
    }

    /* 清除缓存 */
    @ResponseBody
    @RequestMapping("/update")
    public Map<String, Object> update() {
        int result = userMapper.insert(User.builder().build());
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("result", result);
        return map;
    }

}
