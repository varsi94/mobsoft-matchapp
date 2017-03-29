package com.mobsoft.matchapp.ui.standings;

import com.mobsoft.matchapp.ui.Presenter;

import java.util.ArrayList;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class StandingsPresenter extends Presenter<StandingsScreen> {
    public void screenLoaded() {
        this.screen.updateStadings(new ArrayList<String>());
    }
}
