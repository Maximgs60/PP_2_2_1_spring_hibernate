package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      Car car1 = new Car("Audi", 12L);
      Car car2 = new Car("BMW", 525L);
      Car car3 = new Car("Mercedes", 300L);
      Car car4 = new Car("Mazda", 5L);

      userService.add(new User("Andrey", "Sidorovskiy", "AndreyS@mail.ru", car1));
      userService.add(new User("Vadim", "Lopin", "VadimL@mail.ru", car2));
      userService.add(new User("Sergey", "Papin", "SergeyP@mail.ru", car3));
      userService.add(new User("Vasya", "Loginov", "VasyaL@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getFirstName() + "'s " + user.getCars());
         System.out.println("====================");
         System.out.println();
      }
      System.out.println("====================");
      System.out.println("====================");
      System.out.println(userService.getSpecailUser("BMW", 525L));
      System.out.println("====================");
      System.out.println("====================");

      context.close();
   }
}
