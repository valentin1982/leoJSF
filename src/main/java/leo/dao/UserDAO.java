package leo.dao;

import leo.model.User;

import java.util.List;


public interface UserDAO {

    User checkLogin(String login, String password);

    List<User> getAllUsers();

    boolean inserirUser(User user);

    User getUserById(Long id);

    boolean deleteUser(User user);
}
