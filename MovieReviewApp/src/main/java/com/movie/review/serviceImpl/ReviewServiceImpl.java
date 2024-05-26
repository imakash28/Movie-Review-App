package com.movie.review.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.movie.review.entity.Movie;
import com.movie.review.entity.Review;
import com.movie.review.repository.ReviewRepository;
import com.movie.review.service.ReviewService;
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	// Repositories are the one of the way to talk with the database the other ways is Template
	// we can use this template to form a new dynamic query to do the job inside the database without using the repository
	@Autowired
	private MongoTemplate mongoTemplate;	
	
	//We are using the template to perform a update call on movie class because each movie in our collection contains the empty array of reviewIds. so we need to update that array and push a new Id into this
	
	public Review createReview(String reviewBody, String imdbId) {
		Review review = reviewRepository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));
		mongoTemplate.update(Movie.class)	// which class we wan to update using the mongoTemplate i.e. Movie class
		.matching(Criteria.where("imdbId").is(imdbId))	// we have to perform the matching which movie are updating, we are updating the movie where the imdbId of the movie in the database is matches with the imdbId which we are received from the user
		.apply(new Update().push("reviewIds").value(review.getId()))
		.first();		// to make sure that we are getting a single movie and we are updating that
		return review;
		
	}
}
