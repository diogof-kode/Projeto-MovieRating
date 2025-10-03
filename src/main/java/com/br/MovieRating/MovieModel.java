package com.br.MovieRating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class MovieModel {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private float rating;
    private String review;
    private LocalDateTime createdAt;

}
