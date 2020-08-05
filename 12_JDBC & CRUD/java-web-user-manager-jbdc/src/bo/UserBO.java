package bo;

import model.User;

import java.util.List;

public interface UserBO {
    List<User> findAll();

    void save(User user);

    User findById(int id);

//    List<User> findByName(String name);

    void update(int id, User user);

    void remove(int id);
}
