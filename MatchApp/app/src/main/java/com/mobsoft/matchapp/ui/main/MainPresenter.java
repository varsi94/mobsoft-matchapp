package com.mobsoft.matchapp.ui.main;

import android.util.Log;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.TeamInteractor;
import com.mobsoft.matchapp.interactor.events.teams.LoginTeamEvent;
import com.mobsoft.matchapp.interactor.events.teams.SignUpTeamEvent;
import com.mobsoft.matchapp.providers.LoggedInProvider;
import com.mobsoft.matchapp.ui.Presenter;

import javax.inject.Inject;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    TeamInteractor teamInteractor;

    @Inject
    LoggedInProvider loggedInProvider;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        MobSoftApplication.injector.inject(this);
        super.attachScreen(screen);
    }


    public void logIn(final String teamName, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                teamInteractor.login(teamName, password);
            }
        });
    }

    public void onEventMainThread(LoginTeamEvent event){
        if (screen == null) {
            return;
        }

        if (event.getThrowable() != null) {
            screen.logInFinished(false, "Error during logging in: " + event.getThrowable().getMessage() + "!");
            Log.e("LogIn", "Error logging in", event.getThrowable());
        } else {
            if (event.isAnonim()) {
                loggedInProvider.setLoggedInTeam(null);
                screen.logInFinished(true, "Invalid username or password!");
            } else {
                loggedInProvider.setLoggedInTeam(event.getContent());
                screen.logInFinished(event.getContent() != null, "Invalid username or password!");
            }
        }
    }

    public void signUp(final String teamName, final String password) {
        if (isNullOrEmpty(teamName) || isNullOrEmpty(password)) {
            screen.signUpFinished(false, "Team name and password fields are required!");
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                teamInteractor.signUp(teamName, password);
            }
        });
    }

    public void onEventMainThread(SignUpTeamEvent event) {
        if (screen == null) {
            return;
        }

        if (event.getThrowable() != null) {
            screen.signUpFinished(false, "Error during signing up: " + event.getThrowable().getMessage() + "!");
            Log.e("SignUp", "Error signing up", event.getThrowable());
        } else {
            Log.d("SignUp", "Sign up successsful logging in...");
            logIn(event.getContent().getName(), event.getContent().getPassword());
        }
    }
}
