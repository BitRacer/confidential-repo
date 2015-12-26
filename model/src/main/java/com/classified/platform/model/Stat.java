package com.classified.platform.model;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class Stat {
  public enum StatType {
	  SCORE,
	  REP,
	  GAMES,	  
  }
  private StatType type;
  private String value;
}
