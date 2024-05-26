package com.movie.review.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	@Id
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseDate;
	private String trailerLink; 
	private String poster;
	private List<String> genres;
	private List<String> backdrops;
	
	// This is called manual reference relationship and there are some other ways to create relationships in mongoDB. for that read mongoDB docs and google it.
	@DocumentReference		// THis will cause the database to store only the ids of reviews amd the reviews will be in the seprate collection
	private List<Review> reviewIds;
}
