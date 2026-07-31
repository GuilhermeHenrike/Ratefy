package com.example.Ratefy.Controller;

import com.example.Ratefy.Entity.Album;
import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Services.AlbumService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public ResponseEntity<?> getAlbum(HttpSession session) {
        Users user = (Users)session.getAttribute("user");

        if (user == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        try {
            List<Album> albumList = albumService.findAllAlbumByUserId(user);
            return ResponseEntity.ok(albumList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/album")
    public ResponseEntity<?> createAlbum(@Valid @RequestBody Album album, BindingResult result,
                                         HttpSession session) {

        if  (result.hasErrors()) {
            String mensagemErro = result.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }

        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be logged in");
        }

        try {
            albumService.createAlbum(album, user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sucess: Album created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/album")
    public ResponseEntity<?> updateAlbum(@Valid @RequestBody Album album, BindingResult result,
                                         HttpSession session) {

        if (result.hasErrors()) {
            String mensagemErro = result.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
        }

        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be logged in");
        }

        try {
            albumService.updateAlbum(album, user);
            return ResponseEntity.status(HttpStatus.OK).body("Sucess: Album updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/album")
    public ResponseEntity<?> deleteAlbum(@Valid @RequestBody Album album, HttpSession session) {

        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be logged in");
        }

        try {
            albumService.deleteAlbum(album, user);
            return ResponseEntity.status(HttpStatus.OK).body("Sucess: Album deleted");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
