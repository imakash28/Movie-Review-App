package com.movie.review.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatusCode;

import com.movie.review.entity.Movie;

public interface MovieService {

	
	List<Movie> getAllMovies();


	Optional<Movie> getSingleMovie(ObjectId id);


	Optional<Movie> getSingleMovieByImdbId(String imdbId);

}
