package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> getUsers();
   User searchUserCar(String model, int series);
}
