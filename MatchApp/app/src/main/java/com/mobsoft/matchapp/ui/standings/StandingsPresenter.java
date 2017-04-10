package com.mobsoft.matchapp.ui.standings;

import android.util.Log;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.events.teams.GetStandingsEvent;
import com.mobsoft.matchapp.interactor.teams.TeamInteractor;
import com.mobsoft.matchapp.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class StandingsPresenter extends Presenter<StandingsScreen> {
    @Inject
    TeamInteractor teamInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public void screenLoaded() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                teamInteractor.getStandings();
            }
        });
    }

    @Override
    public void attachScreen(StandingsScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void onGetStandingsEvent(GetStandingsEvent event){
        if (screen == null) {
            return;
        }

        if (event.getThrowable() != null) {
            screen.updateStandings(null);
            Log.e("GetStandings", "Error reading stadings", event.getThrowable());
        } else {
            screen.updateStandings(event.getContent());
        }
    }
}
