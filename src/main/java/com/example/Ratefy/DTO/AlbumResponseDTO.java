package com.example.Ratefy.DTO;

import com.example.Ratefy.Entity.Album;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumResponseDTO {

    private Long id;
    private String title;
    private String artist;
    private String coverUrl;
    private String description;
    private Integer rating;

    public AlbumResponseDTO(Album album) {
        this.id = album.getId();
        this.title = album.getTitle();
        this.artist = album.getArtist();
        this.coverUrl = album.getCoverUrl();
        this.description = album.getDescription();
        this.rating = album.getRating();
    }
}