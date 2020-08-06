package com.codegym.bo;

import com.codegym.dao.UserCallDao;
import com.codegym.dao.UserDAO;
import com.codegym.dao.UserDAOImpl;
import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBOImpl implements UserBO{
    private UserDAO userDAO = new UserDAOImpl();
    private UserDAO userCallDao = new UserCallDao();
    @Override
    public List<User> findAll()
    {
        return this.userCallDao.findAll();
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

    @Override
    public List<User> findByCountry(String country) {
        return this.userDAO.findByCountry(country);
    }

//    @Override
//    public void addUserTransaction(User user, int[] permision) {
//        this.userDAO.addUserTransaction(user,permision);
//    }
//
//    @Override
//    public void insertUpdateWithoutTransaction() {
//        this.userDAO.insertUpdateWithoutTransaction();
//    }
//
//    @Override
//    public void insertUpdateUseTransaction() {
//        this.userDAO.insertUpdateUseTransaction();
//    }
//
//    @Override
//    public List<User> getAll() {
//        return this.userDAO.getAll();
//    }

    @Override
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        this.userDAO.insertUserStore(user);
    }
}
