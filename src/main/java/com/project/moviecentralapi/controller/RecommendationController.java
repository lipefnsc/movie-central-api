package com.project.moviecentralapi.controller;

import com.project.moviecentralapi.client.dto.TmdbMovieDTO;
import com.project.moviecentralapi.service.RecommendationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    @Autowired
    private RecommendationFacade recommendationFacade;

    @GetMapping("/{username}")
    public ResponseEntity<List<TmdbMovieDTO>> getRecommendationsForUser(@PathVariable String username) {
        // O controller não sabe de NADA da complexidade.
        // Ele apenas delega a chamada para a Facade.
        List<TmdbMovieDTO> recommendations = recommendationFacade.getRecommendations(username);

        // Se não houver recomendações, poderia retornar um 204 No Content,
        // mas um 200 OK com uma lista vazia também é uma prática comum e mais simples.
        return ResponseEntity.ok(recommendations);
    }
}
