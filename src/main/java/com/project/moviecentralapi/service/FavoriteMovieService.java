package com.project.moviecentralapi.service;

import com.project.moviecentralapi.model.FavoriteMovie;
import com.project.moviecentralapi.model.User;
import com.project.moviecentralapi.repository.FavoriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteMovieService {

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;

    public FavoriteMovie addFavoriteMovie(String username, Long tmdbMovieId) {
        User user = userService.findByUsername(username);

        if( user.getFavoriteMovies().stream().anyMatch(movie -> movie.getTmdbId().equals(tmdbMovieId))) {
            throw new RuntimeException("The movie is already on favorites list.");
        }

        FavoriteMovie newFavorite = new FavoriteMovie();
        newFavorite.setTmdbId(tmdbMovieId);
        newFavorite.setUser(user);

        return favoriteMovieRepository.save(newFavorite);
    }

    public List<FavoriteMovie> getFavoritesByUsername(String username) {
        User user = userService.findByUsername(username);
        return favoriteMovieRepository.findByUser(user);
    }
}
