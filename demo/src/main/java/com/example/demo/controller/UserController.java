package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String welcome() {

        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String showAllUsersFromDataBase(ModelMap model) {
        model.addAttribute("users", userService.showAllUsers());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping(value = "users/add")
    public String addNewUserToDataBase(@ModelAttribute("user") User user) {
        userService.addNewUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUserById(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.showUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "users/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateCurrentUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String showAllUsers(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.showUserById(id));
        return "show";
    }
}

