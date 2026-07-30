package com.example.Ratefy.Repository;

import com.example.Ratefy.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    boolean existsByTitle(String title);
    Album findByTitle(String title);
    boolean existsByIdAndUserId(long id, long userId);

}
