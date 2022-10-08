package ru.kata.spring.boot_security.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repo.RoleRepo;

/**
 * @ In the name of Allah, most gracious and most merciful! 05.10.2022
 */
@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    public Role getRoleByName(String name) {
        return roleRepo.findRoleByName(name);
    }
}
