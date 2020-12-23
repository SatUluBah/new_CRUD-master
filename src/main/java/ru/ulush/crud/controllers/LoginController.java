package ru.ulush.crud.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("showLoginPage")
    public String showLoginPage() {

//        return "loginPage";
        return  "customLogin";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
