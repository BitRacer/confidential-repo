package com.classified.platform.services.user;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classified.platform.model.User;
import com.classified.platform.model.Stat;
import com.classified.platform.model.Stat.StatType;

	@SpringBootApplication
	@EnableDiscoveryClient
	@Controller
	@RequestMapping("/")
	public class UserServiceApplication extends SpringBootServletInitializer {

	  @Override
	  protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
	      return application.sources( UserServiceApplication.class ).web( true );
	  }
	  
	  public static void main( String[] args ) {
	      new SpringApplicationBuilder( UserServiceApplication.class ).web( true ).run( args );
	  }
	  
	  @RequestMapping(value="/me", method=RequestMethod.GET)
	  public @ResponseBody User getMe() {
	  	User returnUser = new User();
	  	returnUser.setId("1");;
	  	returnUser.setFirstName("Aristotle");
	  	returnUser.setLastName("Allen");
	  	returnUser.setAuthToken("2b2d-5e3g-1e2d-feca");
	  	returnUser.setAuthService(User.AuthService.GOOGLE_PLUS);
	  	returnUser.setDisplayName("The IceMan");
	  	returnUser.setEmail("aristotle.allen@gmail.com");
	  	returnUser.setPicture("https://i.ytimg.com/vi/heotcTKCCtk/maxresdefault.jpg");
	    return returnUser;	  
	  }
	  
	  @RequestMapping(value="/user", method=RequestMethod.POST)
	  public @ResponseBody User createUser(@RequestBody User jsonUser) {
		    //do business logic
		    return jsonUser;
		}

	  @RequestMapping(value="/user", method=RequestMethod.GET)
	  public @ResponseBody User getUser(@RequestParam(value="id", required=true) String id) {
	  	User returnUser = new User();
	  	returnUser.setId(id);
	  	returnUser.setFirstName("firstName");
	  	returnUser.setLastName("lastName");
	  	returnUser.setAuthService(User.AuthService.GOOGLE_PLUS);
	    return returnUser;
	  }  
	  
	  @RequestMapping(value="/users", method=RequestMethod.GET)
	  public @ResponseBody ArrayList<User> getUsers() {
		ArrayList<User> retUsers = new ArrayList<>();

		User returnUser = new User();
	  	returnUser.setId("1");
	  	returnUser.setFirstName("Aristotle");
	  	returnUser.setLastName("Allen");
	  	returnUser.setAuthService(User.AuthService.GOOGLE_PLUS);
	  	retUsers.add(returnUser);
	  	
	  	returnUser = new User();
	  	returnUser.setId("2");
	  	returnUser.setFirstName("Julian");
	  	returnUser.setLastName("Garrigou");
	  	returnUser.setAuthService(User.AuthService.GOOGLE_PLUS);
	  	retUsers.add(returnUser);
	  	
	  	returnUser = new User();
	  	returnUser.setId("3");
	  	returnUser.setFirstName("Domenic");
	  	returnUser.setLastName("Haberstumbpf");
	  	returnUser.setAuthService(User.AuthService.GOOGLE_PLUS);
	  	retUsers.add(returnUser);
	  	
	  	return retUsers;
	  }  
	  
	  @RequestMapping(value="/user/stats", method=RequestMethod.GET)
	  public @ResponseBody ArrayList<Stat> getUserStats(@RequestParam(value="id", required=true) String id) {
		  ArrayList<Stat> retList = new ArrayList<>();
		  retList.add(Stat.builder().type(Stat.StatType.REP).value("150").build());
		  retList.add(Stat.builder().type(StatType.SCORE).value("102030").build());
		  return retList;
	  }	  
	  
	  
	
	}
	
