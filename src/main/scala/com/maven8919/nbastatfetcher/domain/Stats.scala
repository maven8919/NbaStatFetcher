package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 19..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class Stats(@BeanProperty @JsonProperty("activePlayers") var activePlayers: java.util.List[Player]) {

  override def toString = s"Stats($activePlayers)"
}
