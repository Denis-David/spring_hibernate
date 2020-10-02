package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;


   @Transactional
    @Override
    public void add(Car model) {

       carDao.add(model);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public User findUserByNameAndSeries(Car car) {
       User user= carDao.findUserByNameAndSeries(car);
        return user;
    }
}
