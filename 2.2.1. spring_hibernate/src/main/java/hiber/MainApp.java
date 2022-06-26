package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User us1 = new User("Evgeniy", "Shevchenko", "enotishe@gmail.com");
      User us2 = new User("Petya", "Sidorov", "sidorov@mail.io");
      User us3 = new User("Vasya", "Ivanov", "ivanov@mail.io");
      User us4 = new User("Svetlana", "Petrova", "petrova@mail.io");

      Car car1 = new Car("BMW", 4);
      Car car2 = new Car("Audi", 365);
      Car car3 = new Car("Hunday", 17);
      Car car4 = new Car("Pego", 43646);

//      userService.add(us1.setCar(car1).setUser(us1));
//      userService.add(us2.setCar(car2).setUser(us2));
//      userService.add(us3.setCar(car3).setUser(us3));
//      userService.add(us4.setCar(car4).setUser(us4));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
//
      // пользователи с машинами
//      for (User user : userService.listUsers()) {
//         System.out.println(user + " " + user.getCar());
//      }
//
      // достать юзера, владеющего машиной по ее модели и серии
//      System.out.println(userService.getUserByCar("BMW", 4));
//
      // нет такого юзера с такой машиной
      try {
         User notFoundUser = userService.getUserByCar("Porsce", 911);
      } catch (NoResultException e) {
         System.out.println("User not found");
      }



      context.close();
   }
}
