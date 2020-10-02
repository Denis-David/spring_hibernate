package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface Dao<T> {
    void add(T model);
    List<T> findAll();
    T findById(Long id);
}
