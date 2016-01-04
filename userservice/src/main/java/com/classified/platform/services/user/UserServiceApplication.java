package com.classified.platform.services.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.classified.platform.model.User;
import com.classified.platform.persistance.repo.UserRepo;
import com.classified.platform.persistance.repo.UserRepoImpl;
import com.google.common.collect.Lists;

@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@ComponentScan("com.classified.platform.persistance.repo")
public class UserServiceApplication extends SpringBootServletInitializer {

	//private Map<String, User> tempUserCache = new ConcurrentHashMap<>();
	
	@Autowired
	UserRepoImpl userRepo;
	//@Autowired
	//CrudRepository<User, String> userRepo = CrudRepository.;

	//@RequestMapping("/datasourceConfig")
	//public @ResponseBody String profile() {
		//return ""; //dao.getJpaConfig().toString() + "\n" + dao.getHibernateConfig().toString();
	//}
		
    public static void main( String[] args ) {
        SpringApplication.run( UserServiceApplication.class, args );
    }

	@RequestMapping(value = "/user/me", method = RequestMethod.GET)
	public @ResponseBody User getMe() {
		return userRepo.findOne("1");
//		User returnUser = new User();
//		returnUser.setId("1");
//		returnUser.setFirstName("Aristotle");
//		returnUser.setLastName("Allen");
//		returnUser.setAuthToken("2b2d-5e3g-1e2d-feca");
//		returnUser.setAuthService(User.AuthService.GOOGLE_PLUS);
//		returnUser.setDisplayName("The IceMan");
//		returnUser.setEmail("aristotle.allen@gmail.com");
//		returnUser.setPicture("https://i.ytimg.com/vi/heotcTKCCtk/maxresdefault.jpg");
//		return returnUser;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public HttpServletResponse createUser(@RequestBody User jsonUser, HttpServletResponse response) {
		//String id = jsonUser.getId();
		//tempUserCache.put(id, jsonUser);
		userRepo.save(jsonUser);
		response.setStatus(response.SC_CREATED);
		return response;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public HttpServletResponse deleteUser(@RequestBody User jsonUser, HttpServletResponse response) {
		//String id = jsonUser.getId();
		//tempUserCache.put(id, jsonUser);
		userRepo.delete(jsonUser);
		response.setStatus(response.SC_OK);
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam(value = "id", required = true) String id) {
		//User retUser = this.tempUserCache.get(id);
		//if (retUser == null) {
			//throw new NullPointerException("User with id " + id + " not found");
		//} 
	    //else {
			//return retUser;
		//}
		return userRepo.findOne(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody Collection<User> getUsers() {
		return Lists.newArrayList(userRepo.findAll());
		//return this.tempUserCache.values();
	}
	
	

	//@RequestMapping(value = "/user/stats", method = RequestMethod.GET)
	//public @ResponseBody ArrayList<Stat> getUserStats(@RequestParam(value = "id", required = true) String id) {
		//ArrayList<Stat> retList = new ArrayList<>();
		//retList.add(Stat.builder().statType(StatType.USER).name("Reputation").value("150").build());
		//retList.add(Stat.builder().statType(StatType.USER).name("Score").value("102030").build());
		//return retList;
	//}

/*	@ControllerAdvice
	class GlobalControllerExceptionHandler {
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(NullPointerException.class)
		public void handleConflict() {
			// just return not found
		}
		
	}
*/
	
}
