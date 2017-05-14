package com.mobsoft.matchapp.repository;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.Team;

import java.util.List;
import java.util.Objects;

/**
 * Created by varsi on 2017. 05. 14..
 */

public abstract class RepositoryBase implements Repository {
    protected int getPlayed(List<Match> matches, Team t) {
        int counter = 0;
        for (Match m : matches) {
            if (Objects.equals(m.getHomeTeam().getId(), t.getId()) || Objects.equals(m.getAwayTeam().getId(), t.getId())){
                counter++;
            }
        }
        return counter;
    }

    protected int getPoints(List<Match> matches, Team t) {
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
}
