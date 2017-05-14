package com.mobsoft.matchapp.providers;

import com.mobsoft.matchapp.model.Team;

/**
 * Created by varsi on 2017. 05. 14..
 */

public interface LoggedInProvider {
    void setLoggedInTeam(Team team);
    Team getLoggedInTeam();
}
