package com.controller;

import com.dao.RoleDao;
import com.dao.UserDao;
import com.model.Role;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("")
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @RequestMapping("/create")
    public Map create() {
        User user = new User();
        user.setName("姓名1");
        user.setPassword("密码1");
        Map map = new LinkedHashMap();
        map.put("result", userDao.save(user));
        return map;
    }

    @RequestMapping("/update")
    public Map update() {
        User user = new User();
        user.setId(null);
        user.setName("name2");
        Map map = new LinkedHashMap();
        map.put("result", userDao.saveAndFlush(user)); /* 搭配hutool copyProperties只更新非null */
        return map;
    }

    @RequestMapping("/delete")
    public Map delete() {
        userDao.deleteById(1);
        Map map = new LinkedHashMap();
        map.put("result", "delete");
        return map;
    }

    @RequestMapping("/selectOne")
    public ModelAndView selectOne() {
        ModelAndView view = new ModelAndView();
        Optional<User> result = userDao.findById(1);
        User user = new User();
        if (result.isPresent()) {
            user = result.get();
        }
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    @RequestMapping("/selectList")
    public Map selectList() {
        Map map = new LinkedHashMap();
        map.put("result", userDao.findAll());
        return map;
    }

    /* JPA Example查询 */
    @RequestMapping("/selectExample")
    public Map selectExample() {
        User user = new User();
        user.setName("name123");
        Example<User> userExample = Example.of(user);
        Sort sort = Sort.by(Sort.Direction.DESC, "id"); /* 排序 */
        List<User> userList = userDao.findAll(userExample, sort);
        System.out.println(userList);

        User user2 = new User();
        user2.setName("123");
        user2.setPassword("pwd");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()).withMatcher("password", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> userExample2 = Example.of(user2, matcher);
        List<User> userList2 = userDao.findAll(userExample2); /* 查询name包含123，pwd包含pwd的记录 */
        System.out.println(userList2);
        return new LinkedHashMap();
    }

    /* 自定义CURD */
    @RequestMapping("/custom")
    public Map custom() {
//        System.out.println(userDao.customInsert("name123", "pwd1"));
//        System.out.println(userDao.customUpdate(1, "name456", "pwd2"));
//        System.out.println(userDao.customDelete(1));
//        Pageable pageable = PageRequest.of(0, 1);
//        List<Map<String, Object>> userList = userDao.customList("name1", pageable);
        return new LinkedHashMap();
    }

    /* 关联 */
    @RequestMapping("/related")
    public Map related() {
//        /* fixme 关联更新（已有的user_role会再插入一次） */
//        Set<Role> roleList = new LinkedHashSet<>(Arrays.asList(Role.builder().roleId(1).roleName("role1").build()));
//        User user = User.builder()
//                .id(1)
//                .name("name1")
//                .roleList(roleList)
//                .build();
//        userDao.saveAndFlush(user);

//        /* 关联查询（使用自定义查询代替） */
//        List<User> userList = userDao.findAll();

//        /* 删除 */
//        userDao.deleteById(1);

        List<Role> roleList = roleDao.findAll();

//        /* fixme 删除（关联的user_role没有删除） */
//        roleDao.deleteById(1);

        return new LinkedHashMap();
    }

}
