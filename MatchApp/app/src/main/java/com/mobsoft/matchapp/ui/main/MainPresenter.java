package com.mobsoft.matchapp.ui.main;

import android.util.Log;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.events.teams.GetStandingsEvent;
import com.mobsoft.matchapp.interactor.events.teams.LoginTeamEvent;
import com.mobsoft.matchapp.interactor.teams.TeamInteractor;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    EventBus bus;

    @Inject
    TeamInteractor teamInteractor;

    @Inject
    Executor executor;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }


    public void login(final String teamName, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                teamInteractor.login(teamName, password);
            }
        });
    }

    public void onLoginTeamEvent(LoginTeamEvent event){
        if (screen == null) {
            return;
        }

        if (event.getThrowable() != null) {
            screen.logInFinished(false, "Error during connecting to the server!");
            Log.e("GetStandings", "Error logging in", event.getThrowable());
        } else {
            screen.logInFinished(event.getContent() != null, "Invalid username or password!");
        }
    }

    public void signup(String teamName, String password) {
    }
}
