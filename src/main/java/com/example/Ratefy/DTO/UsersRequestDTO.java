package com.example.Ratefy.DTO;

import com.example.Ratefy.Entity.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersRequestDTO {

    @NotBlank(message = "The username is required")
    private String username;
    @NotBlank(message = "The password is required")
    private String password;

    public Users toEntity() {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        return users;
    }
}
