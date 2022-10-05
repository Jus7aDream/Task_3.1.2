package ru.kata.spring.boot_security.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.validation.Valid;

/**
 * @ In the name of Allah, most gracious and most merciful! 04.10.2022
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("api")
public class ApiController {
    private final UserService userService;

    @GetMapping("users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "api/users";
    }

    @GetMapping("userCard")
    public String userCard(Model model) {
        model.addAttribute("user", new User());
        return "api/userCard";
    }

    @PostMapping("users")
    public String createUser(@ModelAttribute("user")
                             @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/api/userCard";
        userService.creatUser(user);
        return "redirect:/api/users";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "api/user_id";
    }

    @GetMapping("users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.readUserById(id));
        return "api/edit";
    }

    @PatchMapping("users/{id}")
    public String update(@ModelAttribute("user")
                         @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "api/edit";
        userService.updateUser(id, user);
        return "redirect:/api/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/api/users";
    }
}
