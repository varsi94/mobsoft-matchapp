package com.mobsoft.matchapp.interactor;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.events.matches.AddMatchEvent;
import com.mobsoft.matchapp.interactor.events.matches.GetMatchesEvent;
import com.mobsoft.matchapp.interactor.events.matches.UpdateMatchEvent;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by varsi on 2017. 04. 14..
 */

public class MatchInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public MatchInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getMatchesForTeam(Team team) {
        GetMatchesEvent event = new GetMatchesEvent();
        try {
            List<Match> matches = repository.getMatchesForTeam(team);
            event.setContent(matches);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addMatch(Match m) {
        AddMatchEvent event = new AddMatchEvent();
        try {
            repository.addMatch(m);
            event.setContent(m);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateMatch(Match m) {
        UpdateMatchEvent event = new UpdateMatchEvent();
        try{
            repository.updateMatch(m);
            event.setContent(m);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
