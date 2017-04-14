package com.mobsoft.matchapp.ui.matchlist;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MatchListPresenter extends Presenter<MatchListScreen> {
    public void loadMatchesForTeam(int teamId) {

    }

    @Override
    public void attachScreen(MatchListScreen screen) {
        MobSoftApplication.injector.inject(this);
        super.attachScreen(screen);
    }

    public void onEventMainThread(Object input) {
        //DUMMY
    }
}
