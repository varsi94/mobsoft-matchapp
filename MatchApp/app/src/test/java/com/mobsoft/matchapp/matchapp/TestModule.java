package com.mobsoft.matchapp.matchapp;

import android.content.Context;

import com.mobsoft.matchapp.matchapp.utils.UiExecutor;
import com.mobsoft.matchapp.providers.LoggedInProvider;
import com.mobsoft.matchapp.providers.LoggedInProviderImpl;
import com.mobsoft.matchapp.ui.UiModule;
import com.mobsoft.matchapp.ui.details.DetailsPresenter;
import com.mobsoft.matchapp.ui.editor.EditorPresenter;
import com.mobsoft.matchapp.ui.main.MainPresenter;
import com.mobsoft.matchapp.ui.matchlist.MatchListPresenter;
import com.mobsoft.matchapp.ui.standings.StandingsPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by varsi on 2017. 05. 14..
 */

@Module
public class TestModule {
    private final UiModule uiModule;

    public TestModule(Context context) {
        uiModule = new UiModule(context);
    }

    @Provides
    public Context provideContext() {
        return uiModule.provideContext();
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return uiModule.provideMainPresenter();
    }

    @Provides
    @Singleton
    public MatchListPresenter provideMatchListPresenter(){
        return uiModule.provideMatchListPresenter();
    }

    @Provides
    @Singleton
    public StandingsPresenter provideStandingsPresenter() {
        return uiModule.provideStandingsPresenter();
    }

    @Provides
    @Singleton
    public EditorPresenter provideEditorPresenter(){
        return uiModule.provideEditorPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return uiModule.provideDetailsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return new UiExecutor();
    }

    @Provides
    @Singleton
    public LoggedInProvider provideLoggedInProvider(){
        return uiModule.provideLoggedInProvider();
    }
}
