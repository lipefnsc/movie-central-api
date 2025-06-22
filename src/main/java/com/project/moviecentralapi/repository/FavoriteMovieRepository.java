package com.project.moviecentralapi.repository;

import com.project.moviecentralapi.model.FavoriteMovie;
import com.project.moviecentralapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Long> {
    List<FavoriteMovie> findByUser(User user);
}
