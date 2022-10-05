package ru.kata.spring.boot_security.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ In the name of Allah, most gracious and most merciful! 19.09.2022
 */
@Controller
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/user")
    public String user() {
        return "user";
    }
}