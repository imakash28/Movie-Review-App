package com.movie.review.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.review.entity.Review;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

	Review insert(Review entity);

}
