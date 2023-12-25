package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@EnableAsync
@RestController
@SpringBootApplication
public class MyBatisPlus {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlus.class, args);
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

}
