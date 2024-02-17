package com.mpe.service;

import java.util.List;

import com.mpe.exception.ProductException;
import com.mpe.modal.Review;
import com.mpe.modal.User;
import com.mpe.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
