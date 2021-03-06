package com.mobsoft.matchapp.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class Match extends SugarRecord implements Serializable {
    Team homeTeam;
    Team awayTeam;
    int homeTeamScore;
    int awayTeamScore;
    int homeTeamHalfTimeScore;
    int awayTeamHalfTimeScore;
    String venue;
    Date matchDate;
    String highlights;

    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore, int homeTeamHalfTimeScore, int awayTeamHalfTimeScore, String venue, Date matchDate, String highlights) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamHalfTimeScore = homeTeamHalfTimeScore;
        this.awayTeamHalfTimeScore = awayTeamHalfTimeScore;
        this.venue = venue;
        this.matchDate = matchDate;
        this.highlights = highlights;
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

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
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
        highlights = other.highlights;
    }
}
