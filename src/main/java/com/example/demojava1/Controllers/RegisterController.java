package com.example.demojava1.Controllers;

import com.example.demojava1.Registration.UserRegistration;
import com.example.demojava1.Entities.User;
import com.example.demojava1.Services.EmailService;
import com.example.demojava1.Services.UserService;
import com.example.demojava1.Services.UserServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    private final UserServiceIMPL userService;

    private final EmailService emailService;
    public RegisterController(UserServiceIMPL userService, EmailService emailService) {

        this.userService = userService;
        this.emailService = emailService;
    }

    @ModelAttribute("user")
    public UserRegistration userReg() {
        return new UserRegistration();
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserRegistration userDto) {
        User user =  userService.save(userDto);
        emailService.sendCode(user.getEmail(), user.getUsername());
        return "redirect:/register?success";
    }
}