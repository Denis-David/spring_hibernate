package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService extends DaoService<User> {
    void add(User user);
    List<User> findAll();
    void update(User user);
}
