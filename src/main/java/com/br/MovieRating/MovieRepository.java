package com.br.MovieRating;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <MovieModel, UUID>{
}
