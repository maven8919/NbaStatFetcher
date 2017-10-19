package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 18..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class Games(@BeanProperty @JsonProperty("games") var games: java.util.List[Game]) {

  override def toString = s"Games($games)"
}
