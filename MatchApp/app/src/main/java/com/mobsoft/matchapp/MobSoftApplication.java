package com.mobsoft.matchapp;

import android.app.Application;

import com.mobsoft.matchapp.ui.UiModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MobSoftApplication extends Application {
    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMobSoftApplicationComponent.builder().uiModule(new UiModule(this)).build();
    }
}
