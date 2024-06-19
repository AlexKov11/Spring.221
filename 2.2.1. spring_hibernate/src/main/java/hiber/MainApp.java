package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("car4", 5);
      Car car2 = new Car("car3", 6);
      Car car3 = new Car("car2", 7);
      Car car4 = new Car("car1", 8);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      User userWithCar1 = userService.getUserByCar("car4", 5);
      User userWithCar2 = userService.getUserByCar("car3", 6);
      User userWithCar3 = userService.getUserByCar("car2", 7);
      User userWithCar4 = userService.getUserByCar("car1", 8);

      System.out.println("Данные пользователя с автомобилем 'car4' и 'series 5'" + userWithCar1);
      System.out.println("Данные пользователя с автомобилем 'car3' и 'series 6'" + userWithCar2);
      System.out.println("Данные пользователя с автомобилем 'car2' и 'series 7'" + userWithCar3);
      System.out.println("Данные пользователя с автомобилем 'car1' и 'series 8'" + userWithCar4);

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Машина gользователя: " + user.getCar().getModel());
//         System.out.println();
//      }
      context.close();
   }
}
