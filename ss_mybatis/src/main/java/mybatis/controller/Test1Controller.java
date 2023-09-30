package mybatis.controller;

import mybatis.mapper.Test1Mapper;
import mybatis.model.Test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mybatis")
public class Test1Controller {

    @Autowired
    private Test1Mapper test1Mapper; /* 系统学习 */

    @ResponseBody
    @RequestMapping("/index")
    public Map index() {
        /* todo CURD */
//        Test1 test = new Test1();
//        test1Mapper.insert(test);
//
//        test.setId(1);
//        test.setParentId(1);
//        test1Mapper.updateByIdSelective(test);
//
//        test = test1Mapper.selectById(1);
//
//        test1Mapper.deleteById(1);

        /* todo 主键自增 */
//        Test1 test = new Test1();
//        test1Mapper.insertGeneratedKey(test);
//        System.out.println(test.getId());
//
//        test = new Test1();
//        test1Mapper.insertSelectKey(test);
//        System.out.println(test.getId());

        return new LinkedHashMap();
    }

    /* todo 强大的动态SQL */
    @ResponseBody
    @RequestMapping("/sql")
    public Map sql() {
        Test1 select = new Test1();
        select.setId(7);
        select.setCreateTime("2018-12-26 18:00:00");
//        List<Test1> testList = test1Mapper.selectByWhere(select);

//        select.setCreateTime("2019-01-09 18:00:00");
//        test1Mapper.updateBySet(select);

//        List<Test1> testList = test1Mapper.selectByTrim(select);

        List<Test1> testList = test1Mapper.selectByBind(select);

        return new LinkedHashMap();
    }

}
