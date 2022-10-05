package ru.kata.spring.boot_security.demo.services;

import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

/**
 * @ In the name of Allah, most gracious and most merciful! 05.10.2022
 */
public interface UserService {
    @Transactional(readOnly = true)
    public List<User> getAllUsers();

    public void createUser(User user);

    public User findUserById(Long id);

    public void updateUser(Long id, User updatedUser);

    public boolean deleteUser(Long id);

}
