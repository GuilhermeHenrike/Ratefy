package com.example.Ratefy.Services;

import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Users signUp(Users user) {
        boolean existentUser = usersRepository.existsByUsername(user.getUsername());

        if (existentUser) {
            throw new RuntimeException("Username is already in use");
        }

        String safePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(safePassword);
        return usersRepository.save(user);
    }

    public Users signIn(Users user) {
        Users foundedUser = usersRepository.findByUsername(user.getUsername());

        if (foundedUser == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(user.getPassword(), foundedUser.getPassword())) {
            throw new RuntimeException("Username or passwords don't match");
        }

        return foundedUser;
    }
}
