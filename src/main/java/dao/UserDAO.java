package dao;

import model.User;

import java.util.List;


public interface UserDAO {
    List<User> getAllUsers();

    void save(User user);

    User show(int id);

    void update(User user);

    void delete(int id);
}
