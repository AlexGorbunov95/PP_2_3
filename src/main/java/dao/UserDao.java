package dao;

import model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User showUser(long id);
    void update(Long id, User user);
    void delete(Long id);
}
