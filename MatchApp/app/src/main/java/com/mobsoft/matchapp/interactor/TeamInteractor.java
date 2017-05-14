package com.mobsoft.matchapp.interactor;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.events.teams.GetStandingsEvent;
import com.mobsoft.matchapp.interactor.events.teams.GetTeamsEvent;
import com.mobsoft.matchapp.interactor.events.teams.LoginTeamEvent;
import com.mobsoft.matchapp.interactor.events.teams.SignUpTeamEvent;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by varsi on 2017. 04. 14..
 */

public class TeamInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public TeamInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getStandings() {
        GetStandingsEvent event = new GetStandingsEvent();
        try {
            event.setContent(repository.getStandings());
            bus.post(event);
        } catch(Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void login(String userName, String password) {
        LoginTeamEvent event = new LoginTeamEvent();
        try {
            if (isNullOrEmpty(userName) && isNullOrEmpty(password)) {
                event.setAnonim(true);
            }
            Team t = repository.getTeam(userName, password);
            event.setContent(t);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void signUp(String teamName, String password) {
        SignUpTeamEvent event = new SignUpTeamEvent();
        try {
            Team t = new Team(teamName, password, false);
            if ("admin".equals(teamName.toLowerCase())) {
                t.setAdmin(true);
            }
            repository.addTeam(t);
            event.setContent(t);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getTeams(){
        GetTeamsEvent event = new GetTeamsEvent();
        try {
            List<Team> teams = repository.getTeams();
            event.setContent(teams);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
