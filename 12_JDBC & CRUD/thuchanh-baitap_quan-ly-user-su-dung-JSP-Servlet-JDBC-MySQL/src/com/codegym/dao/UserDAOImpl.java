package com.codegym.dao;

import com.codegym.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SQL = "SELECT id, `name`, email, country FROM users;";


    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement("FIND_ALL_SQL");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void remove(int id) {

    }
}
