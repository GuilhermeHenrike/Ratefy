package com.example.Ratefy.DTO;

import com.example.Ratefy.Entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersResponseDTO {

    private Long id;
    private String username;

    public UsersResponseDTO(Users users) {
        this.id = users.getId();
        this.username = users.getUsername();
    }

}
