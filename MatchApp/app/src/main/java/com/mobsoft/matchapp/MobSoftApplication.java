package com.mobsoft.matchapp;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.repository.Repository;
import com.mobsoft.matchapp.ui.UiModule;

import javax.inject.Inject;

public class MobSoftApplication extends Application {
    private Tracker tracker;
    public static MobSoftApplicationComponent injector;

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent getInjector() {
        return injector;
    }

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMobSoftApplicationComponent.builder().uiModule(new UiModule(this)).build();

        injector.inject(this);
        repository.open(this);
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }
}
