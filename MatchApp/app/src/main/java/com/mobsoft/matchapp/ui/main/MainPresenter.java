package com.mobsoft.matchapp.ui.main;

import com.mobsoft.matchapp.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MainPresenter extends Presenter<MainScreen> {
    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void login(String teamName, String password){
    }

    public void signup(String teamName, String password){
    }
}
