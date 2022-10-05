package ru.kata.spring.boot_security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;

/**
 * @ In the name of Allah, most gracious and most merciful! 29.09.2022
 */
@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.username=?1")
    User findByUsername(String username);
}
