package com.mpe.service;

import com.mpe.exception.ProductException;
import com.mpe.modal.Cart;
import com.mpe.modal.CartItem;
import com.mpe.modal.User;
import com.mpe.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
