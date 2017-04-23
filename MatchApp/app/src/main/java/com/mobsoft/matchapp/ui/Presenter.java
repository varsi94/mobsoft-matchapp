package com.mobsoft.matchapp.ui;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public abstract class Presenter<S> {
    @Inject
    protected Executor executor;

    @Inject
    protected EventBus bus;

    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
        bus.register(this);
    }

    public void detachScreen() {
        this.screen = null;
        bus.unregister(this);
    }

}
