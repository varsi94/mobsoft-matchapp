package com.mobsoft.matchapp.ui.details;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.providers.LoggedInProvider;
import com.mobsoft.matchapp.ui.Presenter;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {
    @Inject
    LoggedInProvider loggedInProvider;

    private Match match;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
        screen.detailsLoaded(match);
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        this.screen = screen;
        MobSoftApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        this.screen = null;
    }

    public boolean canEdit() {
        return loggedInProvider.getLoggedInTeam() != null && (
                loggedInProvider.getLoggedInTeam().getName().equals(match.getHomeTeam().getName()) ||
                loggedInProvider.getLoggedInTeam().getName().equals(match.getAwayTeam().getName()) ||
                loggedInProvider.getLoggedInTeam().isAdmin());
    }
}
