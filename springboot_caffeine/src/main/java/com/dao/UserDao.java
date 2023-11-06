package com.dao;

import com.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@CacheConfig(cacheNames = "caffeineCacheManager")
public interface UserDao extends JpaRepository<User, Integer> {

    @Cacheable(key = "0")
    @Override
    Optional<User> findById(Integer id);

}
