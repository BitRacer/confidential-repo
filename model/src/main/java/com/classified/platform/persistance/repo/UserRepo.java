package com.classified.platform.persistance.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.classified.platform.model.User;

//@Component
public interface UserRepo extends CrudRepository<User, String> {

	/*
	 * TODO figure out the persistance wiring
	 */
}