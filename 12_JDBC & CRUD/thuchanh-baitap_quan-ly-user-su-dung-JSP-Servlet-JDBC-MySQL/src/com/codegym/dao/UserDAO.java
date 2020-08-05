package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    void update(int id, User user);

    void remove(int id);

}
