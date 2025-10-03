package com.br.MovieRating;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/")
    public ResponseEntity addMovie(@RequestBody MovieModel movie) {

        movie.setCreatedAt(LocalDateTime.now());
        movieRepository.save(movie);
        return ResponseEntity.status(201).body(movie);
    }

    @GetMapping("/")
    public ResponseEntity getAllMovies() {

        List<MovieModel> movies = movieRepository.findAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchMovie(@PathVariable UUID id) {

        Optional<MovieModel> movie = movieRepository.findById(id);

        if(movie.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(movie.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@PathVariable UUID id, @RequestBody MovieModel movie){

        Optional<MovieModel> existingMovie = movieRepository.findById(id);

        if(existingMovie.isEmpty()){return ResponseEntity.notFound().build();}

        MovieModel updatedMovie = existingMovie.get();
        updatedMovie.setTitle(movie.getTitle());
        updatedMovie.setRating(movie.getRating());
        updatedMovie.setReview(movie.getReview());

        movieRepository.save(updatedMovie);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable UUID id){

        Optional<MovieModel> existingMovie = movieRepository.findById(id);

        if(existingMovie.isEmpty()){return ResponseEntity.notFound().build();}

        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();



    }
}