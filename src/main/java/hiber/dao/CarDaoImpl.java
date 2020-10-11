package hiber.dao;


import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Car model) {
        sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public Car findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Car car = session.get(Car.class, id);
        return car;
    }

    @Override
    public List<Car> findAll() {
        TypedQuery<Car> query1 = sessionFactory.getCurrentSession().createQuery("from Car");
        return query1.getResultList();
    }

    @Override
    public User findUserByNameAndSeries(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("From User user where user.car.name = :model and user.car.series =:series").setParameter("model", model).setParameter("series", series);
        User user2 = (User) query.setMaxResults(1).getSingleResult();
        return user2;

        //query.getResultList();
   /* public User findUserByNameAndSeries(Car car) {
        Query query1 = sessionFactory.getCurrentSession().createQuery("from User user where user.car.name=:paramName and user.car.series=:paramSeries");
        query1.setParameter("paramName", car.getName());
        query1.setParameter("paramSeries", car.getSeries());
        User user2 = (User) query1.setMaxResults(1).getSingleResult();
        return user2;
    }*/

    }
}
