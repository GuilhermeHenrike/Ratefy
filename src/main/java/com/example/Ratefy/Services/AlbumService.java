package com.example.Ratefy.Services;

import com.example.Ratefy.Entity.Album;
import com.example.Ratefy.Entity.Users;
import com.example.Ratefy.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAllAlbumByUserId(Users user) {

        if (user == null) {
            throw new RuntimeException("You need to login first");
        }

        return albumRepository.findAllByUserId(user.getId());
    }

    public void createAlbum(Album album, Users user) {

        if (user == null) {
            throw new RuntimeException("You need to login first");
        }

        if (album == null) {
            throw new RuntimeException("You must send a Album to add");
        }

        album.setUser(user);
        albumRepository.save(album);
    }

    public void updateAlbum(Long id, Album album, Users user) {

        if (user == null) {
            throw new RuntimeException("You need to login first");
        }

        Album albumFounded = albumRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Album not found"));

        if (!albumFounded.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("This album is not your or you don't have permission to edit");
        }

        if (album.getTitle() != null) {
            albumFounded.setTitle(album.getTitle());
        }

        if (album.getArtist() != null) {
            albumFounded.setArtist(album.getArtist());
        }

        if (album.getDescription() != null) {
            albumFounded.setDescription(album.getDescription());
        }

        if (album.getCoverUrl() != null) {
            albumFounded.setCoverUrl(album.getCoverUrl());
        }

        if  (album.getRating() != null) {
            albumFounded.setRating(album.getRating());
        }

        albumRepository.save(albumFounded);
    }

    public void deleteAlbum(Long id, Users user) {

        if (user == null) {
            throw new RuntimeException("You need to login first");
        }

        Album albumFounded = albumRepository.findByIdAndUserId(id, user.getId());

        if (albumFounded == null) {
            throw new RuntimeException("Album not found");
        }

        albumRepository.delete(albumFounded);
    }
}
