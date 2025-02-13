//package ru.kata.spring.boot_security.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import ru.kata.spring.boot_security.demo.models.User;
//import ru.kata.spring.boot_security.demo.services.UserService;
//import ru.kata.spring.boot_security.demo.services.security.AccountDetails;
//
//import java.util.Arrays;
//
//@Controller
//public class AdminUserController {
//    private UserService userservice;
//
//    @Autowired
//    public AdminUserController(UserService userservice) {
//        this.userservice = userservice;
//    }
//
//    @GetMapping("/user")
//    public String showUser(Model model) {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
//        model.addAttribute("user", accountDetails.getUser());
//        return "user";
//    }
//
//    @GetMapping("/")
//    public String showUsers(Model model) {
//
//        if (userservice.listUsers().isEmpty())
//            userservice.addUser(new User("admin", "admin", Arrays.asList("ROLE_ADMIN")));
//        model.addAttribute("users", userservice.listUsers());
//        User user = new User();
//        model.addAttribute("usernew", user);
//        return "admin";
//    }
//
//    @PostMapping("/admin/register")
//    public String inputUser(@ModelAttribute("user") User user) {
//
//        userservice.addUser(user);
//        return "redirect:/";
//    }
//
//    @PatchMapping("/admin/{id}")
//    public String edit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//
//        userservice.editUser(id, user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/admin/{id}")
//    public String delete(@PathVariable("id") Long id) {
//
//        userservice.deleteUser(id);
//        return "redirect:/";
//    }
//}
//
//
//
//
