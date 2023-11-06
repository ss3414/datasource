package com;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class Caffeine {

    public static void main(String[] args) {
        SpringApplication.run(Caffeine.class, args);
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public Map index() {
        return new LinkedHashMap();
    }

    @RequestMapping("/find")
    public String find() {
        User user = userDao.findById(1).get();
        return user.toString();
    }

}
