package hiber.service;


import hiber.model.User;

import java.util.List;

public interface DaoService <T> {
    void add(T model);
    List<T> findAll();

}
