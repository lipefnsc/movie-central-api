package com.project.moviecentralapi.service;

import com.project.moviecentralapi.client.TmdbClient;
import com.project.moviecentralapi.client.dto.TmdbMovieDTO;
import com.project.moviecentralapi.client.dto.TmdbMovieResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmdbService {

        @Autowired
        private TmdbClient tmdbClient;

        @Value("${tmdb.api.key}")
        private String tmdbApiKey;

        public TmdbMovieDTO findMovieDetails(Long tmdbMovieId) {
            return tmdbClient.getMovieDetails(tmdbMovieId, tmdbApiKey, "pt-BR");
        }

        public List<TmdbMovieDTO> findMovieRecommendations(Long tmdbMovieId) {
            TmdbMovieResponseDTO response = tmdbClient.getMovieRecommendations(tmdbMovieId, tmdbApiKey, "pt-BR");
            return response.getResults();
        }
}
