package com.movie.review.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.review.entity.Movie;
import com.movie.review.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/getSingleMovie/{id}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id ){
		return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(id), HttpStatus.OK);
	}
	@GetMapping("/getSingleMovieByImdbId/{imdbId}")
	public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId ){
		return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovieByImdbId(imdbId), HttpStatus.OK);
	}
}
