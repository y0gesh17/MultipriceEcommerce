package com.mpe.service;

import com.mpe.exception.UserException;
import com.mpe.modal.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;

}
