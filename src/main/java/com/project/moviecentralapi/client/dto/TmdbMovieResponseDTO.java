package com.project.moviecentralapi.client.dto;

import java.util.List;

public class TmdbMovieResponseDTO {
    private List<TmdbMovieDTO> results;

    public List<TmdbMovieDTO> getResults() {
        return results;
    }

    public void setResults(List<TmdbMovieDTO> results) {
        this.results = results;
    }
}
