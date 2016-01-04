package com.classified.platform.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
public @Data @Builder @NoArgsConstructor @AllArgsConstructor class Location {

  public enum LocationType {
	  PUBLIC,
	  PRIVATE
  }

  public enum LocationStatus {
    ACTIVE,
    SUSPENDED
  }

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "LOCATION_ID")
  private String locationId;
  @Column(name = "NAME")
  private String name;
  @Column(name = "DESCRIPTION")
  private String description;
  @Column(name = "LONGITUDE")
  private long longitude;
  @Column(name = "LATITUDE")
  private long latitude;
  @Column(name = "STATUS")
  private LocationType status;
  @Column(name = "TYPE")
  private LocationType type;
}
