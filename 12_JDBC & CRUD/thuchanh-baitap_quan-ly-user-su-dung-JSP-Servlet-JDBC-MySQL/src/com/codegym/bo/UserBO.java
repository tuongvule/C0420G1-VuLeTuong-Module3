package com.codegym.bo;

import com.codegym.model.User;

import java.util.List;

public interface UserBO {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    void update(int id, User user);

    void remove(int id);
}
