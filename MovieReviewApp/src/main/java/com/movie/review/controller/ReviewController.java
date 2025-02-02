package com.movie.review.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.review.entity.Review;
import com.movie.review.service.ReviewService;

@RestController
@RequestMapping("/api/v1/movies")
public class ReviewController {

	
	@Autowired
	private ReviewService reviewService;
	@PostMapping("/createReview")
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
		return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
	}
	
}
