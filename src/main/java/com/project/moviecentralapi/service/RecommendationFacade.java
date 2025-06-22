package com.project.moviecentralapi.service;

import com.project.moviecentralapi.client.dto.TmdbMovieDTO;
import com.project.moviecentralapi.model.FavoriteMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class RecommendationFacade {
    @Autowired
    private FavoriteMovieService favoriteMovieService;

    @Autowired
    private TmdbService tmdbService;

    public List<TmdbMovieDTO> getRecommendations(String username) {
        List<FavoriteMovie> favorites = favoriteMovieService.getFavoritesByUsername(username);

        if (favorites.isEmpty()) {
            return Collections.emptyList(); // Retorna uma lista vazia.
        }

        FavoriteMovie seedMovie = favorites.get(new Random().nextInt(favorites.size()));
        Long seedMovieTmdbId = seedMovie.getTmdbId();

        return tmdbService.findMovieRecommendations(seedMovieTmdbId);
    }
}
