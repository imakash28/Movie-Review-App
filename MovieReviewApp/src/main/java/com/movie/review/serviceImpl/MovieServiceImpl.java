package com.movie.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.movie.review.entity.Movie;
import com.movie.review.repository.MovieRepository;
import com.movie.review.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getSingleMovie(ObjectId id) {
		return movieRepository.findById(id);
	}

	@Override
	public Optional<Movie> getSingleMovieByImdbId(String imdbId) {
		return movieRepository.findByImdbId(imdbId);

	}
	
}
