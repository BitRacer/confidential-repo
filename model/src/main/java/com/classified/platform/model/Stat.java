package com.classified.platform.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="STAT")
public @Data @Builder @NoArgsConstructor @AllArgsConstructor class Stat {

  public enum StatType {
	  USER,
	  GAME,
	  LOCATION
  }

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "STAT_ID")
  private String statId;
  @Column(name = "STAT_REF")
  private String statRef;
  @Column(name = "STAT_TYPE")
  private StatType statType;
  @Column(name = "NAME")
  private String name;
  @Column(name = "VALUE")
  private String value;
}
