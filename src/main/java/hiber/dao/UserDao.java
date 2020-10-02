package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    void update(User user);
}
