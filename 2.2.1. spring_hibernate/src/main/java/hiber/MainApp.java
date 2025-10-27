package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

       User user1 = new User("Artem", "Shatalov", "Artm.sht2016@mail.ru");
       Car car1 = new Car("Audi", 4);
       User user2 = new User("Ivan", "Vizgalin", "Vizgalin.iv@gmail.ru");
       Car car2 = new Car("BMW", 7);
       User user3 = new User("Kirill", "Chariev", "KirCh.2000@mail.ru");
       Car car3 = new Car("Lada", 6);
       User user4 = new User("Rasul", "Abakarov", "Abakar.ras@gmail.ru");
       Car car4 = new Car("Kia", 5);

       user1.setCar(car1);
       user2.setCar(car2);
       user3.setCar(car3);
       user4.setCar(car4);

       userService.addUser(user1);
       userService.addUser(user2);
       userService.addUser(user3);
       userService.addUser(user4);

      List<User> users = userService.getUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }
      context.close();
   }
}

