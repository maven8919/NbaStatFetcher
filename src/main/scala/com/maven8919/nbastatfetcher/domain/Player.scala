package com.maven8919.nbastatfetcher.domain

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/**
  * Created by Levi on 2017. 10. 19..
  */
@JsonIgnoreProperties(ignoreUnknown = true)
class Player(@BeanProperty @JsonProperty("personId") var personId: String,
             @BeanProperty @JsonProperty("teamId") var teamId: String,
             @BeanProperty @JsonProperty("points") var points: String,
             @BeanProperty @JsonProperty("min") var min: String,
             @BeanProperty @JsonProperty("fgm") var fgm: String,
             @BeanProperty @JsonProperty("fga") var fga: String,
             @BeanProperty @JsonProperty("fgp") var fgp: String,
             @BeanProperty @JsonProperty("ftm") var ftm: String,
             @BeanProperty @JsonProperty("fta") var fta: String,
             @BeanProperty @JsonProperty("ftp") var ftp: String,
             @BeanProperty @JsonProperty("tpm") var tpm: String,
             @BeanProperty @JsonProperty("tpa") var tpa: String,
             @BeanProperty @JsonProperty("tpp") var tpp: String,
             @BeanProperty @JsonProperty("offReb") var offReb: String,
             @BeanProperty @JsonProperty("defReb") var defReb: String,
             @BeanProperty @JsonProperty("totReb") var totReb: String,
             @BeanProperty @JsonProperty("assists") var assists: String,
             @BeanProperty @JsonProperty("pFouls") var pFouls: String,
             @BeanProperty @JsonProperty("steals") var steals: String,
             @BeanProperty @JsonProperty("turnovers") var turnovers: String,
             @BeanProperty @JsonProperty("blocks") var blocks: String,
             @BeanProperty @JsonProperty("plusMinus") var plusMinus: String,
             @BeanProperty @JsonProperty("dnp") var dnp: String) {


  override def toString = s"Player($personId, $teamId, $points, $min, $fgm, $fga, $fgp, $ftm, $fta, $ftp, $tpm, $tpa, $tpp, $offReb, $defReb, $totReb, $assists, $pFouls, $steals, $turnovers, $blocks, $plusMinus, $dnp)"
}
