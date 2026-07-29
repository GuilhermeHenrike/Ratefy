package com.example.Ratefy.Controller;

import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Services.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody Users users, BindingResult result) {

        if (result.hasErrors()) {
            String mensagemErro = result.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }

        try {
            authService.signUp(users);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sucess: User created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("signIn")
    public ResponseEntity<?> signIn(@Valid @RequestBody Users users,
                                    BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            String mensagemErro = result.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }

        try {
            Users user = authService.signIn(users);
            session.setAttribute("user", user);
            return ResponseEntity.ok().body("Sucess: Logging");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
