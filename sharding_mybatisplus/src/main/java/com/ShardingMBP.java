package com;

import com.mapper.UserMapper;
import com.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@SpringBootApplication
@MapperScan({"com.**.mapper"})
public class ShardingMBP {

    public static void main(String[] args) {
        SpringApplication.run(ShardingMBP.class, args);
    }

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @RequestMapping("/curd")
    public Map curd() {
        /* 主键由雪花算法生成，对表id取余均匀存储 */
        for (int i = 1; i <= 10; i++) {
            userMapper.insert(User.builder().name("name" + i).build());
        }
        userMapper.updateById(User.builder().id(1L).name("name2").build());
        userMapper.deleteById(1L);
        return new LinkedHashMap();
    }

}
