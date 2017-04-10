package com.mobsoft.matchapp.interactor;

import com.mobsoft.matchapp.interactor.teams.TeamInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

@Module
public class InteractorModule {
    @Provides
    public TeamInteractor provideInteractorModule() {
        return new TeamInteractor();
    }
}
