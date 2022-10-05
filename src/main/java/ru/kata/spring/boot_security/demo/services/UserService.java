package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void creatUser(User user);

    User readUserById(Long id);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
}