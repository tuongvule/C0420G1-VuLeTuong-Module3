package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    void save(User user);

    User findById(int id);

//    List<User> findByName(String name);

    List<User> findByCountry(String country);

    List<User> sortByName();

    void update(int id, User user);

    void remove(int id);
}
