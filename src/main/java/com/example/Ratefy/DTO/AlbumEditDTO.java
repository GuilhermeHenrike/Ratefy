package com.example.Ratefy.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlbumEditDTO {

    @NotBlank(message = "The title is required")
    private String title;
    @NotBlank(message = "The artist name is required")
    private String artist;
    private String description;
    private String coverUrl;
}