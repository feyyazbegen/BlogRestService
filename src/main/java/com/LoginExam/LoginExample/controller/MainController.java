package com.LoginExam.LoginExample.controller;

import com.LoginExam.LoginExample.converter.UserConverter;
import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.request.CreateUserRequest;
import com.LoginExam.LoginExample.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class MainController {
    private final UserConverter userConverter;
    private final BCryptPasswordEncoder passwordEncoder; // ?
    private final UserService userService;

    public MainController( UserConverter userConverter, BCryptPasswordEncoder passwordEncoder, UserService userService) {
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveRegisterPage(@Valid @ModelAttribute("user") CreateUserRequest user, BindingResult result, Model model, Map<String, Object> map) {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "register";
        } else {
            User byUserName = userService.findByUserName(user.getUserName());
            if(byUserName != null){
               model.addAttribute("error","Bu Kullanıcı Var");
               return "register";
            }
            userService.createUser(user);
            map.put("message", "Successful");
        }
        return "register";
    }

    @RequestMapping("/detail")
    public String secure(Map<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        map.put("message", "Kullanıcı Detaylı bilgileri");
        map.put("user", auth.getName());
        return "detail";
    }



}
