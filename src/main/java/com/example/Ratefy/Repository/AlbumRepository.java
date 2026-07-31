package com.example.Ratefy.Repository;

import com.example.Ratefy.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findAllByUserId(Long userId);
    Album findByIdAndUserId(long id, long userId);

}
