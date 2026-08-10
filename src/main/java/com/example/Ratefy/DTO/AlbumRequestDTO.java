package com.example.Ratefy.DTO;

import com.example.Ratefy.Entity.Album;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumRequestDTO {

    @NotBlank(message = "The title is required")
    private String title;
    @NotBlank(message = "The artist name is required")
    private String artist;

    private String description;
    private String coverUrl;
    private Integer rating;

    public Album toEntity() {
        Album album = new Album();
        album.setTitle(this.title);
        album.setArtist(this.artist);
        album.setDescription(this.description);
        album.setCoverUrl(this.coverUrl);
        album.setRating(this.rating);
        return album;
    }

}
