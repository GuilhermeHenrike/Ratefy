package com.example.Ratefy.Controller;

import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Services.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("user/userUsername")
    public ResponseEntity<?> getUsers(@RequestParam String userUsername, HttpSession session) {

        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be logged in");
        }

        try {
            List<Users> searched = usersService.searchUsers(userUsername, user);
            return ResponseEntity.ok(searched);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
