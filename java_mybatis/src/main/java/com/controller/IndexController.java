package com.controller;

import com.dao.IUserDao;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();
        User user = userDao.selectById(User.builder().id(1).build());
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    @ResponseBody
    @RequestMapping("/transaction")
    public Map transaction() {
        userService.transaction();
        return new LinkedHashMap();
    }

}
