package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao extends Dao<Car> {
    User findUserByNameAndSeries(Car car);
}
