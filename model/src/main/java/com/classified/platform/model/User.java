package com.classified.platform.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="USER")
public @Data @Builder @NoArgsConstructor @AllArgsConstructor class User {
	
  public enum AuthService {
	  GOOGLE_PLUS,
	  FACEBOOK,
	  TWITTER,
	  GITHUB
  }
  @Id
  @GeneratedValue
  @Column(name = "USER_ID")
  private String id;
  @Column(name = "DISPLAY_NAME")
  private String displayName;
  @Column(name = "FIRST_NAME")
  private String firstName;
  @Column(name = "LAST_NAME")
  private String lastName;
  @Column(name = "EMAIL")
  private String email;
  @Column(name = "PICTURE")
  private String picture;
  @Column(name = "AUTH_TOKEN")
  private String authToken;
  @Column(name = "AUTH_SERVICE")
  private AuthService authService;
  
}