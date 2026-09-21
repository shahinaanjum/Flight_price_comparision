package com.Flight_Price_Comparision.Controller;

import com.Flight_Price_Comparision.Model.entity.users;
import com.Flight_Price_Comparision.Service.JwtService;
import com.Flight_Price_Comparision.Service.usersService;
import com.Flight_Price_Comparision.dto.LoginRequest;
import com.Flight_Price_Comparision.dto.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final usersService usersService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(
            usersService usersService,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<users> register(
            @RequestBody RegisterRequest request) {

        users user = new users();

        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        user.setRoll(request.getRoll());

        users savedUser = usersService.createUser(user);

        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request) {

        return usersService.getUserByEmail(request.getEmail())
                .map(user -> {

                    if (passwordEncoder.matches(
                            request.getPassword(),
                            user.getPassword())) {

                        String token =
                                jwtService.generateToken(user.getEmail());

                        return ResponseEntity.ok(token);
                    }

                    return ResponseEntity.status(401)
                            .body("Invalid email or password");
                })
                .orElse(
                        ResponseEntity.status(401)
                                .body("Invalid email or password")
                );
    }
}