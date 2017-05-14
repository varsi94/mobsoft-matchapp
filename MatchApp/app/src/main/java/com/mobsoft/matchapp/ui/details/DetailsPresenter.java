package com.mobsoft.matchapp.ui.details;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {
    private Match match;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        this.screen = screen;
    }

    @Override
    public void detachScreen() {
        this.screen = null;
    }
}
