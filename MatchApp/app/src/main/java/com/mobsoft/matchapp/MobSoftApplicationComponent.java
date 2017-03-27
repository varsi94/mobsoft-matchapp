package com.mobsoft.matchapp;

import com.mobsoft.matchapp.ui.UiModule;
import com.mobsoft.matchapp.ui.details.DetailsActivity;
import com.mobsoft.matchapp.ui.editor.EditorActivity;
import com.mobsoft.matchapp.ui.main.MainActivity;
import com.mobsoft.matchapp.ui.standings.StandingsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UiModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(StandingsActivity standingsActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(EditorActivity editorActivity);
}
