package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 19..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class BasicGameData(@BeanProperty @JsonProperty("startDateEastern") var startDateEastern: String,
                    @BeanProperty @JsonProperty("vTeam") var vTeam: VTeam,
                    @BeanProperty @JsonProperty("hTeam") var hTeam: HTeam) {

    override def toString = s"BasicGameData($startDateEastern, $vTeam, $hTeam)"
}
