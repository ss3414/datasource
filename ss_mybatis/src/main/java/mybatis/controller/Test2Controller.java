package mybatis.controller;

import mybatis.mapper.Test2Mapper;
import mybatis.model.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mybatis")
public class Test2Controller {

    @Autowired
    private Test2Mapper test2Mapper; /* 自行总结 */

    /* todo 包装器类 */
    @ResponseBody
    @RequestMapping("/boxing")
    public Map boxing() {
//        int id = 1;
//        Test2 test = test2Mapper.selectByInteger(id);
//        Integer id2 = 1; /* 自动装箱 */
//        Test2 test2 = test2Mapper.selectByInt(id2);

        return new LinkedHashMap();
    }

    @ResponseBody
    @RequestMapping("/param")
    public Map param() {
        /* todo 传入参数（基本类型集合） */
//        int[] array = {1, 2};
//        List<Test2> testList = test2Mapper.selectByArray(array);

        /* 不带泛型 */
//        List list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        List<Test2> testList = test2Mapper.selectByList(list);

//        Map map = new LinkedHashMap();
//        map.put("id1", 1);
//        map.put("id2", 2);
//        List<Test2> testList = test2Mapper.selectByMap(map);

        /* 遍历Map中的集合 */
//        int[] array = {1, 2};
//        Map map = new LinkedHashMap();
//        map.put("array2", array);
//        List<Test2> testList = test2Mapper.selectByMap2(map);

        /* todo 传入参数（对象集合） */
//        Test2 t1 = new Test2();
//        t1.setId(1);
//        Test2 t2 = new Test2();
//        t2.setId(2);

//        Test2[] array = {t1, t2};
//        List<Test2> testList = test2Mapper.selectByArrayObject(array);

        /* 不带泛型 */
//        List list = new ArrayList();
//        list.add(t1);
//        list.add(t2);
//        List<Test2> testList = test2Mapper.selectByListObject(list);

//        Map map = new LinkedHashMap();
//        map.put("id1", t1);
//        map.put("id2", t2);
//        List<Test2> testList = test2Mapper.selectByMapObject(map);

//        Test2[] array = {t1, t2};
//        Map map = new LinkedHashMap();
//        map.put("array2", array);
//        List<Test2> testList = test2Mapper.selectByMapObject2(map);

        /* todo 传入参数（对象中的基本类型集合） */
//        Test2 select = new Test2();

//        int[] array = {1, 2};
//        select.setSelectArray(array);
//        List<Test2> testList = test2Mapper.selectByObjectArray(select);

//        List list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        select.setSelectList(list);
//        List<Test2> testList = test2Mapper.selectByObjectList(select);

//        Map map = new LinkedHashMap();
//        map.put("id1", 1);
//        map.put("id2", 2);
//        select.setSelectMap(map);
//        List<Test2> testList = test2Mapper.selectByObjectMap(select);

        /* todo 传入参数（对象中的对象集合） */
        Test2 select = new Test2();

        Test2 t1 = new Test2();
        t1.setId(1);
        Test2 t2 = new Test2();
        t2.setId(2);

//        List list = new ArrayList();
//        list.add(t1);
//        list.add(t2);
//        select.setSelectList(list);
//        List<Test2> testList = test2Mapper.selectByObjectListObject(select);

        Map map = new LinkedHashMap();
        map.put("id1", t1);
        map.put("id2", t2);
        select.setSelectMap(map);
        List<Test2> testList = test2Mapper.selectByObjectMapObject(select);

        return new LinkedHashMap();
    }

    /* todo varchar型时间 */
    @ResponseBody
    @RequestMapping("/time")
    public Map time() {
//        Test2 select = new Test2();
//        select.setBeginTime("2018-12-26");
//        select.setEndTime("2018-12-28");
//        List<Test2> testList = test2Mapper.selectByCreateTime3(select.getBeginTime(), select.getEndTime());

        Map select = new LinkedHashMap();
        select.put("beginTime", "2018-12-26");
        select.put("endTime", "2018-12-28");
        List<Test2> testList = test2Mapper.selectByCreateTime4(select);

        Map map = new LinkedHashMap();
        for (int i = 0; i < testList.size(); i++) {
            map.put(String.valueOf(i), testList.get(i).toString());
        }
        return map;
    }

    /* todo MyBatis转义符 */
    @ResponseBody
    @RequestMapping("/escape")
    public Map escape() {
        Test2 select = new Test2();
        select.setCreateTime("2018-12-26");
        List<Test2> testList = test2Mapper.selectByEscape(select);

        return new LinkedHashMap();
    }

    /* todo select count返回值 */
    @ResponseBody
    @RequestMapping("/count")
    public Map count() {
//        int count = test2Mapper.selectCount();

        List<Test2> testList = test2Mapper.selectCount2();

        return new LinkedHashMap();
    }

}
