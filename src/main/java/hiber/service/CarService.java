package hiber.service;

import hiber.model.Car;
import hiber.model.User;

public interface CarService extends DaoService<Car> {
    User findUserByNameAndSeries(Car car);

}
