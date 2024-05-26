package com.movie.review.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.review.entity.Movie;
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

	Optional<Movie> findByImdbId(String imdbId);

}
