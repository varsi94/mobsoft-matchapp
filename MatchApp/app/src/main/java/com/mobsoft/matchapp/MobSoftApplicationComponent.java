package com.mobsoft.matchapp;

import com.mobsoft.matchapp.interactor.InteractorModule;
import com.mobsoft.matchapp.interactor.MatchInteractor;
import com.mobsoft.matchapp.interactor.TeamInteractor;
import com.mobsoft.matchapp.repository.RepositoryModule;
import com.mobsoft.matchapp.ui.UiModule;
import com.mobsoft.matchapp.ui.details.DetailsActivity;
import com.mobsoft.matchapp.ui.details.DetailsPresenter;
import com.mobsoft.matchapp.ui.editor.EditorActivity;
import com.mobsoft.matchapp.ui.editor.EditorPresenter;
import com.mobsoft.matchapp.ui.main.MainActivity;
import com.mobsoft.matchapp.ui.main.MainPresenter;
import com.mobsoft.matchapp.ui.matchlist.MatchListActivity;
import com.mobsoft.matchapp.ui.matchlist.MatchListPresenter;
import com.mobsoft.matchapp.ui.standings.StandingsActivity;
import com.mobsoft.matchapp.ui.standings.StandingsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UiModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(StandingsActivity standingsActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(EditorActivity editorActivity);
    void inject(MatchListActivity matchListActivity);
    void inject(MobSoftApplication app);
    void inject(StandingsPresenter standingsPresenter);
    void inject(MainPresenter mainPresenter);
    void inject(MatchListPresenter matchListPresenter);
    void inject(TeamInteractor teamInteractor);
    void inject(MatchInteractor matchInteractor);
    void inject(EditorPresenter editorPresenter);
    void inject(DetailsPresenter detailsPresenter);
}
