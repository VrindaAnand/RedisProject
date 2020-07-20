package com.crud.redis2.repository;

import com.crud.redis2.model.User;

import java.util.List;
import java.util.Map;

public interface userRepository {

    void save(User user);
    Map<String, User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);

}
