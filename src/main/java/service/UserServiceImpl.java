package service;

import model.User;
import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional()
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional()
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional()
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional()
    public void delete(int id) {
        userDao.delete(id);
    }
}
