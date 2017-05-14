package com.mobsoft.matchapp.providers;

import com.mobsoft.matchapp.model.Team;

/**
 * Created by varsi on 2017. 05. 14..
 */

public class LoggedInProviderImpl implements LoggedInProvider {
    private Team loggedInTeam;

    @Override
    public void setLoggedInTeam(Team team) {
        loggedInTeam = team;
    }

    @Override
    public Team getLoggedInTeam() {
        return loggedInTeam;
    }
}
