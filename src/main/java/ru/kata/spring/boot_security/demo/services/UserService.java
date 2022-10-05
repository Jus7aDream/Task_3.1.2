package ru.kata.spring.boot_security.demo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.configs.WebSecurityConfig;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repo.UserRepo;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
//    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userRepo.findAll();
    }

    public void createUser(User user) {
        log.info("Saving user: {}", user);
//        boolean
//        User userFromDB = userRepo.findByUsername(user.getUsername());
//        if (userFromDB != null) {
//            return false;
//        }
//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepo.save(user);
//        return true;
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        log.info("Getting user with id: {}", id);
//        Optional<User> userFromDb = userRepo.findById(id);
//        return userFromDb.orElse(new User());
        return userRepo.findById(id).orElse(null);
    }

    public void updateUser(Long id, User updatedUser) {
        log.info("Updated user {} with id: {}", updatedUser, id);
        User user = userRepo.findById(id).orElse(null);
        if (user.getId() == null) {
            userRepo.save(updatedUser);
        } else {
            userRepo.save(updatedUser);
        }
    }

    public boolean deleteUser(Long id) {
        log.info("Try to delete user by id: {}", id);

        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            log.info("User by id: {} deleted", id);
            return true;
        }
        log.info("Try to delete user by id: {} failed", id);
        return false;

//        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;

    }
}