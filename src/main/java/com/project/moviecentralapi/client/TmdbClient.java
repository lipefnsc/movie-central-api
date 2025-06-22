package com.project.moviecentralapi.client;

import com.project.moviecentralapi.client.dto.TmdbMovieDTO;
import com.project.moviecentralapi.client.dto.TmdbMovieResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tmdbClient", url = "https://api.themoviedb.org/3")
public interface TmdbClient {

    @GetMapping("/movie/{movieId}")
    TmdbMovieDTO getMovieDetails(
            @PathVariable("movieId") Long movieId,
            @RequestParam("api_key") String apiKey,
            @RequestParam("language") String language
    );

    @GetMapping("/movie/{movieId}/recommendations")
    TmdbMovieResponseDTO getMovieRecommendations(
            @PathVariable("movieId") Long movieId,
            @RequestParam("api_key") String apiKey,
            @RequestParam("language") String language
    );
}
