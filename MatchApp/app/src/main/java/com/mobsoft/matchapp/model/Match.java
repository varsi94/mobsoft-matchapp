package com.mobsoft.matchapp.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class Match extends SugarRecord {
    Team homeTeam;
    Team awayTeam;
    int homeTeamScore;
    int awayTeamScore;
    int homeTeamHalfTimeScore;
    int awayTeamHalfTimeScore;
    String venue;
    Date matchDate;

    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore, int homeTeamHalfTimeScore, int awayTeamHalfTimeScore, String venue, Date matchDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamHalfTimeScore = homeTeamHalfTimeScore;
        this.awayTeamHalfTimeScore = awayTeamHalfTimeScore;
        this.venue = venue;
        this.matchDate = matchDate;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamHalfTimeScore() {
        return homeTeamHalfTimeScore;
    }

    public void setHomeTeamHalfTimeScore(int homeTeamHalfTimeScore) {
        this.homeTeamHalfTimeScore = homeTeamHalfTimeScore;
    }

    public int getAwayTeamHalfTimeScore() {
        return awayTeamHalfTimeScore;
    }

    public void setAwayTeamHalfTimeScore(int awayTeamHalfTimeScore) {
        this.awayTeamHalfTimeScore = awayTeamHalfTimeScore;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public void update(Match other) {
        homeTeam = other.homeTeam;
        awayTeam = other.awayTeam;
        homeTeamScore = other.homeTeamScore;
        awayTeamScore = other.awayTeamScore;
        homeTeamHalfTimeScore = other.homeTeamHalfTimeScore;
        awayTeamHalfTimeScore = other.awayTeamHalfTimeScore;
        venue = other.venue;
        matchDate = other.matchDate;
    }
}
