package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 19..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class VTeam(@BeanProperty @JsonProperty("teamId") var teamId: String,
            @BeanProperty @JsonProperty("score") var score: String) {

  override def toString = s"VTeam($teamId, $score)"
}
