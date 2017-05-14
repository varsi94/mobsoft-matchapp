package com.mobsoft.matchapp.ui.editor;

import android.provider.Settings;
import android.util.Log;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.MatchInteractor;
import com.mobsoft.matchapp.interactor.TeamInteractor;
import com.mobsoft.matchapp.interactor.events.matches.AddMatchEvent;
import com.mobsoft.matchapp.interactor.events.matches.UpdateMatchEvent;
import com.mobsoft.matchapp.interactor.events.teams.GetStandingsEvent;
import com.mobsoft.matchapp.interactor.events.teams.GetTeamsEvent;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.ui.Presenter;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class EditorPresenter extends Presenter<EditorScreen> {
    @Inject
    TeamInteractor teamInteractor;

    @Inject
    MatchInteractor matchInteractor;

    private Match currentMatch;
    private boolean isNew;

    @Override
    public void attachScreen(EditorScreen screen) {
        MobSoftApplication.injector.inject(this);
        super.attachScreen(screen);
    }

    public void loadTeams() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                teamInteractor.getTeams();
            }
        });
    }

    public void saveMatchDetails(final Match match) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (isNew) {
                    matchInteractor.addMatch(match);
                } else {
                    matchInteractor.updateMatch(match);
                }
            }
        });
    }

    public void onEventMainThread(GetTeamsEvent teamsEvent) {
        if (teamsEvent.getThrowable() == null) {
            screen.teamsLoaded(teamsEvent.getContent());
        } else {
            screen.showMessage("Teams could not be loaded!");
        }
    }

    public void onEventMainThread(AddMatchEvent event) {
        if (event.getThrowable() == null) {
            screen.matchSaved();
        } else {
            screen.showMessage("Could not save the match!");
        }
    }

    public void onEventMainThread(UpdateMatchEvent event) {
        if (event.getThrowable() == null) {
            screen.matchSaved();
        } else {
            screen.showMessage("Could not save the match!");
        }
    }

    public Match getCurrentMatch() {
        return currentMatch;
    }

    public void setCurrentMatch(Match currentMatch, boolean isNew) {
        this.currentMatch = currentMatch;
        this.isNew = isNew;
        screen.matchLoaded(currentMatch);
    }
}
