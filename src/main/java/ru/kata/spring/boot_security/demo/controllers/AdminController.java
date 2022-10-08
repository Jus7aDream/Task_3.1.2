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
@RequestMapping("admin")
public class AdminController {
    private final UserService userService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("model");
        return "admin/admin";
    }

    @GetMapping("users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.findAllUsers());
        return "admin/users";
    }

    @GetMapping("userCard")
    public String userCard(Model model) {
        model.addAttribute("user", new User());
        return "admin/userCard";
    }

    @GetMapping("users/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user";
//        return "admin/user_id";
    }

    @PostMapping("users")
    public String addUser(@ModelAttribute("user")
                          @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/admin/userCard";
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "admin/edit";
    }

    @PatchMapping("users/{id}")
    public String updateUser(@ModelAttribute("user")
                             @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "admin/edit";
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
//****************************************************************


//***************************************************************
//    @GetMapping("all")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.findAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("find/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
//        User user = userService.findUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestBody User user) {
//        User newUser = userService.addUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User updateUser = userService.updateUser(user);
//        return new ResponseEntity<>(updateUser, HttpStatus.OK);
//    }
//
//    @DeleteMapping ("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
