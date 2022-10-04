package ru.kata.spring.boot_security.demo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repo.UserRepo;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userRepo.findAll();
    }

    @Override
    public void addUser(User user) {
        log.info("Saving user: {}", user);
        userRepo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        log.info("Getting user with id: {}", id);
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        log.info("Updated user {} with id: {}", updatedUser, id);
        User user = userRepo.findById(id).orElse(null);
        if (user.getId() == null) {
            userRepo.save(updatedUser);
        } else {
            userRepo.save(updatedUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Delete user by id: {}", id);
        userRepo.deleteById(id);
    }
}