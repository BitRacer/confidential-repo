package com.classified.platform.services.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.classified.platform.model.User;
import com.classified.platform.persistance.repo.UserRepo;

@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class UserServiceApplication {

	
	@Autowired
	UserRepo userRepo;

    public static void main( String[] args ) {
        SpringApplication.run( UserServiceApplication.class, args );
    }

	@RequestMapping(value = "/user/me", method = RequestMethod.GET)
	public @ResponseBody User getMe() {
		return (User)userRepo.findOne("1");
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public HttpServletResponse createUser(@RequestBody User jsonUser, HttpServletResponse response) {
		userRepo.save(jsonUser);
		response.setStatus(HttpServletResponse.SC_CREATED);
		return response;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public HttpServletResponse deleteUser(@RequestBody User jsonUser, HttpServletResponse response) {
		userRepo.delete(jsonUser);
		response.setStatus(HttpServletResponse.SC_OK);
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam(value = "id", required = true) String id) {
		return (User)userRepo.findOne(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody Collection<User> getUsers() {
		List<User> retList = new ArrayList();
		userRepo.findAll().forEach(user -> retList.add(user));
		return retList;
	}	

}
