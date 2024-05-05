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
      userService.add(new User("Oleg", "Gazmonov", "oleg@gazmanov.ru",
              new Car("Toyota", 1337)));
      userService.add(new User("Leonid", "Agutin", "Lenya_agutin@rambler.ru",
              new Car("Audi", 2378)));
      userService.add(new User("Aleksey", "Vorobyev", "leha1337@yandex.ru",
              new Car("Citroen", 2895)));
      userService.add(new User("Iosif", "Kobzon", "gop_stop@mail.ru",
              new Car("Nissan", 6734)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }

      try{
         System.out.println(userService.getUserByCar("Citroen", 2899 ));
      }catch (NoResultException e) {
         System.out.println("Not found");
      }

      context.close();
   }
}
