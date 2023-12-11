package com.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/*
 * 项目通用Mapper
 * ①普通的Mapper接口直接继承泛型实体类即可（UserMapper extends Mapper<User>）
 * ②只继承泛型实体类则只能使用通用Mapper提供的方法
 * ③项目中通用的方法再通过MyMapper<T>包装一下又可以复用
 * */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
