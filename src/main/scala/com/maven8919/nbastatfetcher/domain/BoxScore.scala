package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 19..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class BoxScore(@BeanProperty @JsonProperty("basicGameData") var basicGameData: BasicGameData,
               @BeanProperty @JsonProperty("stats") var stats: Stats) {

  override def toString = s"BoxScore($basicGameData, $stats)"
}
