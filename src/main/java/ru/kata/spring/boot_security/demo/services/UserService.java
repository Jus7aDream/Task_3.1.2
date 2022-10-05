package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

/**
 * @ In the name of Allah, most gracious and most merciful! 05.10.2022
 */
public interface UserService {

    User findUserById(Long id);

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(Long id, User updatedUser);

    boolean deleteUser(Long id);
}