package com.mobsoft.matchapp.repository;

import android.content.Context;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.repository.exceptions.NotFoundException;
import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    private int getPlayed(List<Match> matches, Team t) {
        int counter = 0;
        for (Match m : matches) {
            if (Objects.equals(m.getHomeTeam().getId(), t.getId()) || Objects.equals(m.getAwayTeam().getId(), t.getId())){
                counter++;
            }
        }
        return counter;
    }

    private int getPoints(List<Match> matches, Team t) {
        int counter = 0;
        for (Match m : matches) {
            if (Objects.equals(m.getHomeTeam().getId(), t.getId()) && m.getHomeTeamScore() >= m.getAwayTeamScore()) {
                counter += (m.getHomeTeamScore() == m.getAwayTeamScore()) ? 1 : 3;
            } else if (Objects.equals(m.getAwayTeam().getId(), t.getId()) && m.getAwayTeamScore() >= m.getHomeTeamScore()) {
                counter += (m.getHomeTeamScore() == m.getAwayTeamScore()) ? 1 : 3;
            }
        }
        return counter;
    }

    @Override
    public List<StandingsItem> getStandings() {
        List<Team> teams = Team.listAll(Team.class);
        List<Match> matches = Match.listAll(Match.class);
        List<StandingsItem> result = new ArrayList<>();
        for (Team t : teams) {
            if ("admin".equals(t.getName().toLowerCase())) {
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
        List<Team> teams  = Team.find(Team.class, "name = ?", team.getName());
        if (teams.size() > 0) {
            throw new RuntimeException("There is already a team with this name!");
        }
        SugarRecord.saveInTx(team);
    }

    @Override
    public Team getTeam(String teamName, String password) {
        List<Team> result = Team.find(Team.class, "name = ? AND password = ?", teamName, password);
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public List<Match> getMatchesForTeam(Team team) {
        return team.getMatches();
    }

    @Override
    public void addMatch(Match match) {
        SugarRecord.save(match);
    }

    @Override
    public void updateMatch(Match match) {
        Match inDb = SugarRecord.findById(Match.class, match.getId());
        if (inDb == null) {
            throw new NotFoundException("Match with given id not found!");
        }
        inDb.update(match);
        match.save();
    }

    @Override
    public List<Team> getTeams() {
        return Team.find(Team.class, "name != ?", "admin");
    }

    @Override
    public boolean isInDb(Match match) {
        return SugarRecord.findById(Match.class, match.getId()) != null;
    }

    @Override
    public boolean isInDb(Team team) {
        return SugarRecord.findById(Team.class, team.getId()) != null;
    }
}
