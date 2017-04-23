package com.mobsoft.matchapp.ui.matchlist;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.MatchInteractor;
import com.mobsoft.matchapp.interactor.events.matches.GetMatchesEvent;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.ui.Presenter;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MatchListPresenter extends Presenter<MatchListScreen> {
    @Inject
    MatchInteractor matchInteractor;

    public void loadMatchesForTeam(final Team team) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                matchInteractor.getMatchesForTeam(team);
            }
        });
    }

    @Override
    public void attachScreen(MatchListScreen screen) {
        MobSoftApplication.injector.inject(this);
        super.attachScreen(screen);
    }

    public void onEventMainThread(GetMatchesEvent event) {
        if (screen == null) {
            return;
        }

        if (event.getThrowable() != null) {
            screen.matchLoadFailed("Unable to load matches!");
        } else {
            screen.matchesLoaded(event.getContent());
        }
    }
}
