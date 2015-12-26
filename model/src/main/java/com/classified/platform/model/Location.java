package com.classified.platform.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

public @Data @Builder @NoArgsConstructor @AllArgsConstructor class Location {
  private enum LocationType {
	PUBLIC,
	PRIVATE
  }
  private enum LocationStatus {
    ACTIVE,
    SUSPENDED
  }
  
  private String locationId;
  private String name;
  private String description;
  private long longitude;
  private long latitude;
  private LocationType status;
  private LocationType type;
}
