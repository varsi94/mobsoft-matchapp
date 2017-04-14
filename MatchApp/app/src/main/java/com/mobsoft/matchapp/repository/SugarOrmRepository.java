package com.mobsoft.matchapp.repository;

import android.content.Context;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.repository.exceptions.NotFoundException;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<StandingsItem> getStandings() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void addTeam(Team team) {
        SugarRecord.saveInTx(team);
    }

    @Override
    public Team getTeam(String teamName, String password) {
        List<Team> result = Team.find(Team.class, "teamName = ? AND password = ?", teamName, password);
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public List<Match> getMatchesForTeam(Team team) {
        //TODO: may not working.
        return Match.find(Match.class, "awayTeam = ? OR homeTeam = ?", team.getId().toString(), team.getId().toString());
    }

    @Override
    public void addMatch(Match match) {
        SugarRecord.saveInTx(match);
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
    public boolean isInDb(Match match) {
        return SugarRecord.findById(Match.class, match.getId()) != null;
    }

    @Override
    public boolean isInDb(Team team) {
        return SugarRecord.findById(Team.class, team.getId()) != null;
    }
}
