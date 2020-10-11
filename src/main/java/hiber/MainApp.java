package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.CarServiceImpl;
import hiber.service.DaoService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru", new Car("bmw",7));
        User user2 = new User("User2", "Lastname2", "user2@mail.ru", new Car("Jeep",8));
        User user3 = new User("User3", "Lastname3", "user3@mail.ru", new Car("Audi",9));
        User user4 = new User("User4", "Lastname4", "user4@mail.ru", new Car("Porshe",100));
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        List<Car> cars = carService.findAll();
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            System.out.println("Id = " + car.getId());
            System.out.println("First Name = " + car.getName());
            System.out.println("Last Name = " + car.getSeries());
            System.out.println();
        }

        User user = carService.findUserByNameAndSeries("Audi", 9);
        System.out.println(user + " at  name and series");
        context.close();

        
        /*String name = "Audi";
        int series = 9;
        Car car1 = new Car();
        car1.setName(name);
        car1.setSeries(series);*/


    }
}
