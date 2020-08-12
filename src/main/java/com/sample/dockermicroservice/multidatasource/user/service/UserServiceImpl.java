package com.sample.dockermicroservice.multidatasource.user.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.sample.dockermicroservice.multidatasource.exception.ValidationException;
import com.sample.dockermicroservice.multidatasource.user.domain.User;
import com.sample.dockermicroservice.multidatasource.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public User getUserDetails(Long id) {
	    LOGGER.debug("Getting User details for id {}",id);
		return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public User createUser(User user) throws ValidationException  {
	    LOGGER.debug("Creating User details for user name {}",user.getFirstName());
	    //Validating user details before save
	    if(StringUtils.isEmpty(user.getFirstName())){
	        throw new ValidationException("First Name cannot be null");
	    }
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) throws ValidationException {
	    LOGGER.debug("Updating User details for user id {}",user.getUserId());
        if(!userRepository.findById(user.getUserId()).isPresent()) {
            throw new ValidationException("User id not found for update");
        }
		return userRepository.save(user);
	}

	@Override
	public void removeUser(Long id) {
		 userRepository.deleteById(id);		
	}

	
}
