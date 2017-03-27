package com.mobsoft.matchapp.ui;

import android.content.Context;

import com.mobsoft.matchapp.ui.details.DetailsPresenter;
import com.mobsoft.matchapp.ui.editor.EditorPresenter;
import com.mobsoft.matchapp.ui.main.MainPresenter;
import com.mobsoft.matchapp.ui.matchlist.MatchListPresenter;
import com.mobsoft.matchapp.ui.standings.StandingsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Module
public class UiModule {
    private Context context;

    public UiModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public MatchListPresenter provideMatchListPresenter(){
        return new MatchListPresenter();
    }

    @Provides
    @Singleton
    public StandingsPresenter provideStandingsPresenter() {
        return new StandingsPresenter();
    }

    @Provides
    @Singleton
    public EditorPresenter provideEditorPresenter(){
        return new EditorPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }
}
