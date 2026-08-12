package com.example.Ratefy.Services;

import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> searchUsers(String username, Users userLogado) {

        if (userLogado == null) {
            throw new IllegalArgumentException("You need to login first");
        }

        if (username == null || username.isEmpty()) {
            return java.util.Collections.emptyList();
        }

        return usersRepository.findByUsernameContainingIgnoreCase(username);
    }

}
