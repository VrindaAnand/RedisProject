package com.crud.redis2.repository;

import com.crud.redis2.model.User;
import com.crud.redis2.repository.userRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class userRepositoryImpl implements userRepository {

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;

    public userRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String id) {
        return (User)hashOperations.get("USER", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER", id);
    }

}