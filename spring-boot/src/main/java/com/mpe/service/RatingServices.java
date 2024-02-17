package com.mpe.service;

import java.util.List;

import com.mpe.exception.ProductException;
import com.mpe.modal.Rating;
import com.mpe.modal.User;
import com.mpe.request.RatingRequest;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
