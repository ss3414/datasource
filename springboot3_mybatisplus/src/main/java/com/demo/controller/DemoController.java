package com.demo.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();
        User user = userMapper.selectById(1);
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    /* 多数据源 */
    @DS("servlant")
    @RequestMapping("/dynamic")
    public ModelAndView dynamic() {
        ModelAndView view = new ModelAndView();
        User user = userMapper.selectById(1);
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    @RequestMapping("/page")
    public Map<String, Object> page(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page<User> userPage = new Page<>();
        userPage.setCurrent(currentPage);
        userPage.setSize(1);
        IPage<User> userList = userMapper.selectPage(userPage, new QueryWrapper<User>().lambda().eq(User::getName, "name123"));
//        IPage<User> userList = userMapper.selectPage(
//                userPage, new QueryWrapper<User>().in("", Arrays.asList(""))
//                        .eq("name", "name123"));

        User user = User.builder().build();
        user.setName("name123");
        List<User> userList2 = userService.selectPageByUser(userPage, user); /* 自定义分页 */

//        userList2.forEach(e -> e.setId(null));
//        userService.saveBatch(userList2); /* 批量插入 */

        /* 查询集合（in） */
        List<String> nameList = new ArrayList<>();
        nameList.add("name123");
        nameList.add("name456");
        List<User> userList3 = userMapper.selectList(new QueryWrapper<User>().lambda().in(User::getName, nameList));

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", userList.getSize());
        return map;
    }

    @RequestMapping("/update")
    public Map<String, Object> update() {
        User user = User.builder().name("name2").password(null).build(); /* 默认null值不更新 */
        userMapper.update(user, new QueryWrapper<User>().lambda().eq(User::getId, 1));
        return new LinkedHashMap<>();
    }

    @RequestMapping("/transaction")
    public Map<String, Object> transaction() {
        userService.transaction();
        return new LinkedHashMap<>();
    }

    @SneakyThrows
    @RequestMapping("/test")
    public Map<String, Object> test() {
        /* 写二进制 */
//        var bytes = Files.readAllBytes(Paths.get("C:/Users/Administrator/Desktop/test.jpg"));
//        var user = User.builder().password(bytes).build();
//        userMapper.insert(user);

        /* 读二进制 */
        var user = userMapper.selectOne(new QueryWrapper<>());
        var file = new File("C:/Users/Administrator/Desktop/test2.jpg");
        Files.write(file.toPath(), user.getPassword());
        return new LinkedHashMap<>();
    }

}
