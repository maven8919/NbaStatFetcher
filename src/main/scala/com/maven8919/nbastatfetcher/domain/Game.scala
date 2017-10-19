package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 18..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class Game(@BeanProperty @JsonProperty("gameId") var gameId: String) {

  override def toString = s"Game($gameId)"
}
