package com.sample.dockermicroservice.multidatasource.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.dockermicroservice.multidatasource.user.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	
}
