package com.example.Ratefy.Controller;

import com.example.Ratefy.Services.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/deezer")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class DeezerController {

    @Autowired
    private DeezerService deezerService;

    @GetMapping("search")
    public ResponseEntity<List<Map<String, String>>> searchAlbum(@RequestParam String query) {
        List<Map<String, String>> album = deezerService.searchAlbum(query);
        return ResponseEntity.ok(album);
    }

}