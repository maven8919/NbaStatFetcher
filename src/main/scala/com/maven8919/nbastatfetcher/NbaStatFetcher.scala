package com.maven8919.nbastatfetcher

import java.text.SimpleDateFormat
import java.util.Calendar

import com.maven8919.nbastatfetcher.domain.{BoxScore, Games}
import org.springframework.web.client.RestTemplate
/**
  * Created by Levi on 2017. 10. 18..
  */
object NbaStatFetcher {

  def main(args: Array[String]): Unit = {
    val calendar = Calendar.getInstance
    calendar.add(Calendar.DATE, -1)
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val yesterdayInyyyyMMdd: String = dateFormat.format(calendar.getTime)
    val restTemplate = new RestTemplate
    val yesterdaysGames = restTemplate.getForObject(s"http://data.nba.net/10s/prod/v1/${yesterdayInyyyyMMdd}/scoreboard.json", classOf[Games])
    yesterdaysGames.games.forEach(game => {
      val boxScore = restTemplate.getForObject(s"http://data.nba.net/10s/prod/v1/${yesterdayInyyyyMMdd}/${game.gameId}_boxscore.json", classOf[BoxScore])
    })
  }
}
