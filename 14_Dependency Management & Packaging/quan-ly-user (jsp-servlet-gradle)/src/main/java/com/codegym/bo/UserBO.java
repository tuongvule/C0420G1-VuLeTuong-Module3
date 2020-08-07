package com.codegym.bo;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBO {

    List<User> findAll();

    void save(User user);

    User findById(int id);

    void update(int id, User user);

    void remove(int id);

    public User getUserById(int id);

    public void insertUserStore(User user) throws SQLException;

    List<User> findByCountry(String country);
    public void addUserTransaction(User user, int[] permision);
    public void insertUpdateWithoutTransaction();
    public void insertUpdateUseTransaction();
    List<User> getAll();
}
