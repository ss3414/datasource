package mybatis.controller;

import mybatis.mapper.Test1Mapper;
import mybatis.model.Test1;
import mybatis.model.rbac.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mybatis")
public class MyBatisController1 {

    @Autowired
    private Test1Mapper test1Mapper; /* 系统学习 */

    @ResponseBody
    @RequestMapping("/index")
    public Map index() {

        /************************************************************半分割线******************************/
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

        /************************************************************半分割线******************************/
        /* todo 主键自增 */

//        Test1 test = new Test1();
//        test1Mapper.insertGeneratedKey(test);
//        System.out.println(test.getId());
//
//        test = new Test1();
//        test1Mapper.insertSelectKey(test);
//        System.out.println(test.getId());

        /************************************************************半分割线******************************/
        /* todo MyBatis 注解方式 */

//        Test1 test = new Test1();
//        test1Mapper.insert2(test);
//
//        test.setId(1);
//        test.setParentId(1);
//        test1Mapper.updateById2(test);
//
//        test = test1Mapper.selectById2(1);
//
//        test1Mapper.deleteById2(1);

        Map map = new HashMap();
        return map;
    }

    /************************************************************分割线************************************************************/
    /* todo 强大的动态SQL */

    /**/
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

        Map map = new HashMap();
        return map;
    }

    /************************************************************分割线************************************************************/
    /* todo MyBatis 高级查询 */

    /* fixme 一对一数据不全，一对多失败 */
    /* 一对一映射 */
    @ResponseBody
    @RequestMapping("/advance")
    public Map advance() {
        User user = test1Mapper.selectUserAndRoleById(1);
        user = test1Mapper.selectUserAndRoleById2(1);

        Map map = new HashMap();
        map.put("user", user);
        return map;
    }

    /* 一对多映射 */
    @ResponseBody
    @RequestMapping("/advance2")
    public Map advance2() {
        User user = test1Mapper.selectUserAndRoleById3(1);

        Map map = new HashMap();
        map.put("user", user);
        return map;
    }

}
