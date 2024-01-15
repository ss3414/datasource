package com.demo.dao;

import com.demo.model.User;
import jakarta.annotation.Nonnull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@CacheConfig(cacheNames = "caffeineCacheManager")
public interface UserDao extends JpaRepository<User, Integer> {

    @Cacheable(key = "0")
    @Nonnull
    @Override
    Optional<User> findById(@Nonnull Integer id);

}
