package com.example.Ratefy.Controller;

import com.example.Ratefy.DTO.UsersRequestDTO;
import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Services.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody UsersRequestDTO usersDto, BindingResult result) {

        if (result.hasErrors()) {
            String mensagemErro = result.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }

        try {
            Users users = usersDto.toEntity();
            authService.signUp(users);
            return ResponseEntity.status(HttpStatus.CREATED).body("Success: User created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("signIn")
    public ResponseEntity<?> signIn(@Valid @RequestBody UsersRequestDTO usersDto,
                                    BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            String mensagemErro = result.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }

        try {
            Users users = usersDto.toEntity();
            Users user = authService.signIn(users);
            session.setAttribute("user", user);
            return ResponseEntity.ok().body("Success: Login successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
