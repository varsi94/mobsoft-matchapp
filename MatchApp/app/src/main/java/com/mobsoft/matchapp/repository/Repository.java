package com.mobsoft.matchapp.repository;

import android.content.Context;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.Team;

import java.util.List;

public interface Repository {
    void open(Context context);

    void close();

    List<Team> getStandings();

    void addTeam(Team team);

    Team getTeam(String teamName, String password);

    List<Match> getMatchesForTeam(Team team);

    void addMatch(Match match);

    void updateMatch(Match match);

    boolean isInDb(Match match);

    boolean isInDb(Team team);
}
