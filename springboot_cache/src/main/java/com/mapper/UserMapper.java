package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@CacheConfig(cacheNames = "user")
public interface UserMapper extends BaseMapper<User> {

    @Cacheable(key = "0")
    @Override
    User selectById(Serializable id);

    /* fixme 更新后清除user缓存 */
    @CacheEvict(key = "0", beforeInvocation = true)
    @Override
    int updateById(User entity);

    /* 删除后清除所有缓存 */
    @CacheEvict(key = "0", allEntries = true)
    @Override
    int deleteById(Serializable id);

}
