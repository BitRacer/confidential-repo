package com.classified.platform.persistance.repo;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classified.platform.model.User;

@Repository
@Transactional
@Service
@ComponentScan("com.classified.platform.model")
public interface UserRepo extends JpaRepository<User, String> {

	/*
	 * TODO figure out the persistance wiring
	 */
}

