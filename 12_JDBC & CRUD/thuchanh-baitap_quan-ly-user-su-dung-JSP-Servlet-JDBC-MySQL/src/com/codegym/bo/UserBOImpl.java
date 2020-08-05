package com.codegym.bo;

import com.codegym.dao.UserDAO;
import com.codegym.dao.UserDAOImpl;
import com.codegym.model.User;

import java.util.List;

public class UserBOImpl implements UserBO{
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<User> findAll() {
        return this.userDAO.findAll();
    }

    @Override
    public void save(User user) {
        this.userDAO.save(user);
    }

    @Override
    public User findById(int id) {
        return this.userDAO.findById(id);
    }

    @Override
    public void update(int id, User user) {
        this.userDAO.update(id,user);
    }

    @Override
    public void remove(int id) {
        this.userDAO.remove(id);
    }
}
