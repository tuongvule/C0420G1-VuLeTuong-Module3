package com.codegym.dao;

import com.codegym.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCallDao implements UserDAO {
    BaseDAO baseDAO = new BaseDAO();
    @Override
    public List<User> findAll() {
        User user = null;
        List<User> list = new ArrayList<>();
        String query = "{CALL get_user()}";

        try {
            Connection connection = baseDAO.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);
                list.add(user);
            }
        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;
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

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {

    }

    @Override
    public List<User> findByCountry(String country) {
        return null;
    }

}
