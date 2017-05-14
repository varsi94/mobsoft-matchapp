package com.mobsoft.matchapp.utils;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.network.model.MatchHomeTeam;
import com.mobsoft.matchapp.network.model.StandingsItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class Mapper {
    public static Team mapTeam(com.mobsoft.matchapp.network.model.Team team){
        if (team == null) {
            return null;
        }
        Team t = new Team();
        t.setName(team.getName());
        t.setPassword(team.getPassword());
        t.setAdmin(team.getIsAdmin());
        return t;
    }

    public static Team mapTeam(com.mobsoft.matchapp.network.model.MatchHomeTeam team){
        if (team == null){
            return null;
        }
        Team t = new Team();
        t.setName(team.getName());
        t.setId(t.getId());
        return t;
    }

    public static MatchHomeTeam mapHomeTeam(Team team) {
        if (team == null) {
            return null;
        }
        MatchHomeTeam result = new MatchHomeTeam();
        result.setName(team.getName());
        result.setId(new BigDecimal(team.getId()));
        return result;
    }

    private static StandingsItem mapStandingsItem(com.mobsoft.matchapp.model.StandingsItem item) {
        if (item == null){
            return null;
        }
        StandingsItem result = new StandingsItem();
        result.setName(item.getName());
        result.setPlayed(BigDecimal.valueOf(item.getPlayed()));
        result.setPoints(BigDecimal.valueOf(item.getPoint()));
        return result;
    }

    public static List<StandingsItem> mapStandings(List<com.mobsoft.matchapp.model.StandingsItem> standings) {
        if (standings == null) {
            return null;
        }
        List<StandingsItem> items = new ArrayList<>();
        for (com.mobsoft.matchapp.model.StandingsItem si : standings) {
            items.add(mapStandingsItem(si));
        }
        return items;
    }

    public static Match mapMatch(com.mobsoft.matchapp.network.model.Match m) {
        if (m == null) {
            return null;
        }
        Match result = new Match(Mapper.mapTeam(m.getHomeTeam()),
                Mapper.mapTeam(m.getAwayTeam()),
                m.getHomeTeamScore().intValue(),
                m.getAwayTeamScore().intValue(),
                m.getHomeTeamHalfTimeScore().intValue(),
                m.getAwayTeamHalfTimeScore().intValue(),
                m.getVenue(),
                m.getMatchDate(),
                m.getHighlights());
        return result;
    }

    public static com.mobsoft.matchapp.network.model.Match mapMatch(Match m) {
        if (m == null) {
            return null;
        }
        com.mobsoft.matchapp.network.model.Match result = new com.mobsoft.matchapp.network.model.Match();
        result.setHomeTeam(mapHomeTeam(m.getHomeTeam()));
        result.setAwayTeam(mapHomeTeam(m.getAwayTeam()));
        result.setHomeTeamScore(new BigDecimal(m.getHomeTeamScore()));
        result.setAwayTeamScore(new BigDecimal(m.getAwayTeamScore()));
        result.setHomeTeamHalfTimeScore(new BigDecimal(m.getHomeTeamHalfTimeScore()));
        result.setAwayTeamHalfTimeScore(new BigDecimal(m.getAwayTeamHalfTimeScore()));
        result.setVenue(m.getVenue());
        result.setHighlights(m.getHighlights());
        result.setMatchDate(m.getMatchDate());
        return result;
    }

    public static com.mobsoft.matchapp.network.model.Team mapTeam(Team t) {
        if (t == null){
            return null;
        }
        com.mobsoft.matchapp.network.model.Team result = new com.mobsoft.matchapp.network.model.Team();
        result.setName(t.getName());
        result.setPassword(t.getPassword());
        result.setIsAdmin(t.isAdmin());
        return result;
    }
}
