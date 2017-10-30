package com.maven8919.nbastatfetcher

import java.text.SimpleDateFormat
import java.util.Calendar

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import com.maven8919.nbastatfetcher.domain.{BoxScore, Games}
import org.springframework.web.client.RestTemplate
/**
  * Created by Levi on 2017. 10. 18..
  */
object NbaStatFetcher {

  val header = "startDate,visitingTeamId,visitingTeamScore,homeTeamId,homeTeamScore,personId,teamId,points,min,fgm,fga,fgp,ftm,fta,ftp,tpm,tpa,tpp,offReb,defReb,totReb,assists,pFouls,steals,turnovers,blocks,plusMinus"

  def main(args: Array[String]): Unit = {
    val calendar = Calendar.getInstance
    calendar.add(Calendar.DATE, -1)
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val yesterdayInyyyyMMdd: String = dateFormat.format(calendar.getTime)
    var result = ""
//    val pw = new PrintWriter(new File(s"$yesterdayInyyyyMMdd.csv" ))
//    pw.write(header + "\n")
    result += header + "\n"
    val restTemplate = new RestTemplate
    val yesterdaysGames = restTemplate.getForObject(s"http://data.nba.net/10s/prod/v1/${yesterdayInyyyyMMdd}/scoreboard.json", classOf[Games])
    yesterdaysGames.games.forEach(game => {
      val boxScore = restTemplate.getForObject(s"http://data.nba.net/10s/prod/v1/${yesterdayInyyyyMMdd}/${game.gameId}_boxscore.json", classOf[BoxScore])
      boxScore.stats.activePlayers.forEach(player => {
        result +=
          s"${boxScore.basicGameData.startDateEastern}," +
            s"${boxScore.basicGameData.vTeam.teamId},${boxScore.basicGameData.vTeam.score}," +
            s"${boxScore.basicGameData.hTeam.teamId},${boxScore.basicGameData.hTeam.score}," +
            s"${player.personId}," +
            s"${player.teamId}," +
            s"${player.points}," +
            s"${player.min}," +
            s"${player.fgm}," +
            s"${player.fga}," +
            s"${player.fgp}," +
            s"${player.ftm}," +
            s"${player.fta}," +
            s"${player.ftp}," +
            s"${player.tpm}," +
            s"${player.tpa}," +
            s"${player.tpp}," +
            s"${player.offReb}," +
            s"${player.defReb}," +
            s"${player.totReb}," +
            s"${player.assists}," +
            s"${player.pFouls}," +
            s"${player.steals}," +
            s"${player.turnovers}," +
            s"${player.blocks}," +
            s"${player.plusMinus}\n"
      })
    })
    val s3client: AmazonS3 = AmazonS3ClientBuilder.standard.withRegion(Regions.US_EAST_1).build
    s3client.putObject("nba-data-maven8919", s"$yesterdayInyyyyMMdd.csv", result)
  }
}
