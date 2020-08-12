package com.sample.dockermicroservice.multidatasource.user.service;

import com.sample.dockermicroservice.multidatasource.exception.ValidationException;
import com.sample.dockermicroservice.multidatasource.user.domain.User;

public interface UserService {

	public User getUserDetails(Long id);
	
	public User createUser(User user) throws ValidationException;
	
	public User updateUser(User user) throws ValidationException;
	
	public void removeUser(Long id);
		
}
