package com.example.Ratefy.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class DeezerService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, String>> searchAlbum(String query) {

        String url = "https://api.deezer.com/search/album?q=" + query;

        try {
            org.springframework.http.ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> body = response.getBody();

            if (body != null &&  body.containsKey("data")) {
                List<Map<String, Object>> data = (List<Map<String, Object>>) body.get("data");

                return data.stream().map(album -> {
                    String title = (String) album.get("title");
                    String coverUrl = (String) album.get("cover_medium");

                    String artistName = "";
                    if  (album.containsKey("artist") && album.get("artist") instanceof Map) {
                        Map<String, Object> artistObj = (Map<String, Object>) album.get("artist");
                        artistName = (String) artistObj.get("name");
                    }

                    return Map.of(
                            "title", title != null ? title : "",
                            "artistName", artistName != null ? artistName : "",
                            "cover_url", coverUrl != null ? coverUrl : ""
                    );
                }).collect(java.util.stream.Collectors.toList());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error: " + e.getMessage());
        }

        return java.util.Collections.emptyList();
    }

}
