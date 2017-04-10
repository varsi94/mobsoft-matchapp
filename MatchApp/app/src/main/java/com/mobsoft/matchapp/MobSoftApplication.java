package com.mobsoft.matchapp;

import android.app.Application;

import com.mobsoft.matchapp.repository.Repository;
import com.mobsoft.matchapp.ui.UiModule;

import javax.inject.Inject;

public class MobSoftApplication extends Application {
    public static MobSoftApplicationComponent injector;

    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMobSoftApplicationComponent.builder().uiModule(new UiModule(this)).build();

        injector.inject(this);
        repository.open(this);
    }
}
