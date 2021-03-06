package com.mobsoft.matchapp.repository;

import android.content.Context;
import android.util.Log;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.model.Team;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class MemoryRepository extends RepositoryBase {
    public static List<Team> teams;
    public static List<Match> matches;

    @Override
    public void open(Context context) {
        teams = new ArrayList<>();
        matches = new ArrayList<>();

        Team team1 = new Team("team1", "123456", false);
        team1.setId(1L);
        Team team2 = new Team("team2", "123456", false);
        team2.setId(2L);
        Team admin = new Team("admin", "123", true);
        admin.setId(3L);
        Team team3 = new Team("team3", "123456", false);
        team3.setId(4L);
        teams.add(team1);
        teams.add(team2);
        teams.add(admin);
        teams.add(team3);

        Calendar c = new GregorianCalendar();
        c.set(2017, 5, 22, 20, 45, 0);
        Match match = new Match(team1, team2, 1, 2, 0, 1, "Bogdánfy utca 11", c.getTime(), "");
        matches.add(match);
    }

    @Override
    public void close() {

    }

    @Override
    public List<StandingsItem> getStandings() {
        Log.d("MemoryRepository", "GetStandings");
        List<StandingsItem> result = new ArrayList<>();
        for (Team t: teams) {
            if (t.getName().equals("admin")) {
                continue;
            }
            result.add(new StandingsItem(t, getPoints(matches, t), getPlayed(matches, t)));
        }
        Collections.sort(result, new Comparator<StandingsItem>() {
            @Override
            public int compare(StandingsItem o1, StandingsItem o2) {
                return o2.getPoint() - o1.getPoint();
            }
        });
        return result;
    }

    @Override
    public void addTeam(Team team) {
        for (Team t : teams) {
            if (Objects.equals(t.getName(), team.getName())) {
                throw new RuntimeException("There is already a team with this name!");
            }
        }
        teams.add(team);
    }

    @Override
    public Team getTeam(String teamName, String password) {
        for (Team team : teams) {
            if(team.getName().equals(teamName) && team.getPassword().equals(password)) {
                return team;
            }
        }

        return null;
    }

    @Override
    public List<Match> getMatchesForTeam(Team team) {
        List<Match> matches = new ArrayList<>();
        for (Match m : MemoryRepository.matches) {
            if (Objects.equals(m.getHomeTeam().getId(), team.getId()) || Objects.equals(m.getAwayTeam().getId(), team.getId())) {
                matches.add(m);
            }
        }
        return matches;
    }

    @Override
    public void addMatch(Match match) {
        matches.add(match);
    }

    @Override
    public void updateMatch(Match match) {
        for (int i = 0; i < matches.size(); i++) {
            if (Objects.equals(matches.get(i).getId(), match.getId())) {
                matches.set(i, match);
                return;
            }
        }
    }

    @Override
    public List<Team> getTeams() {
        List<Team> result = new ArrayList<>();
        for (Team t : teams) {
            if (t.getName().equals("admin")) {
                continue;
            }
            result.add(t);
        }
        return result;
    }

    @Override
    public boolean isInDb(Match match) {
        for (Match m : matches) {
            if (m == match) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isInDb(Team team) {
        for (Team t : teams) {
            if (t == team) {
                return true;
            }
        }
        return false;
    }
}
