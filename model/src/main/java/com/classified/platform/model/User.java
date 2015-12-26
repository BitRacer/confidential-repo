package com.classified.platform.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
public @Data @Builder @NoArgsConstructor @AllArgsConstructor class User {
	
  public enum AuthService {
	  GOOGLE_PLUS,
	  FACEBOOK,
	  TWITTER,
	  GITHUB
  }
  private String id;
  private String displayName;
  private String firstName;
  private String lastName;
  private String email;
  private String picture;
  private String authToken;
  private AuthService authService;
  
}