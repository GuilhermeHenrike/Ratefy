package com.example.Ratefy.Services;

import com.example.Ratefy.DTO.UsersResponseDTO;
import com.example.Ratefy.DTO.AlbumResponseDTO;
import com.example.Ratefy.Entity.Album;
import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Repository.AlbumRepository;
import com.example.Ratefy.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public List<UsersResponseDTO> searchUsers(String username, Users user) {

        if (user == null) {
            throw new IllegalArgumentException("You need to login first");
        }

        if (username == null || username.isEmpty()) {
            return java.util.Collections.emptyList();
        }

        List<Users> users = usersRepository.findByUsernameContainingIgnoreCase(username);

        return users.stream()
                .map(userI -> new UsersResponseDTO(userI))
                .toList();
    }

    public List<AlbumResponseDTO> profile(Long id, Users user) {

        if (user == null) {
            throw new IllegalArgumentException("You need to login first");
        }

        if (id == null) {
            throw new IllegalArgumentException("You must provide an ID");
        }

        if (!usersRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }

        List<Album> albums = albumRepository.findAllByUserId(id);

        return albums.stream()
                .map(albumI -> new AlbumResponseDTO(albumI))
                .toList();
    }
}
