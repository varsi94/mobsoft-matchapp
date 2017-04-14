package com.mobsoft.matchapp.interactor.teams;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.events.teams.GetStandingsEvent;
import com.mobsoft.matchapp.interactor.events.teams.LoginTeamEvent;
import com.mobsoft.matchapp.interactor.events.teams.SignUpTeamEvent;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.repository.Repository;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 10..
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
            Team t = new Team(0L, teamName, password);
            repository.addTeam(t);
            event.setContent(t);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
