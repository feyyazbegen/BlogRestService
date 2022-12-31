package com.LoginExam.LoginExample.controller;
import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.request.AuthRequest;
import com.LoginExam.LoginExample.request.CreateUserRequest;
import com.LoginExam.LoginExample.security.JwtTokenProvider;
import com.LoginExam.LoginExample.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){
        UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword());
        Authentication auth = authenticationManager.authenticate(authtoken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        return "Bearer " + jwtToken;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CreateUserRequest request){
        if(userService.findByUserName(request.getUserName()) !=null){
            return new ResponseEntity<>("Username already exist.", HttpStatus.BAD_REQUEST);
        }

        userService.createUser(request);
        return new ResponseEntity<>("User successfully registered.",HttpStatus.OK);

    }

}