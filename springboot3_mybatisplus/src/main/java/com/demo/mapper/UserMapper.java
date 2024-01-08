package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    /* 将对象作为参数传入查询 */
    List<User> selectPageByUser(Page page, @Param("user") User user);

    @Select({"""
            <script>
            SELECT id as user_id,name as user_name,password as user_pwd
            FROM `user`
            <if test='name != null'> WHERE name = #{name} </if>
            </script>
            """})
    List<Map<String, Object>> selectMapList(@Param("name") String name);

}
