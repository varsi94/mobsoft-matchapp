package com.mobsoft.matchapp.interactor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

@Module
public class InteractorModule {
    @Provides
    @Singleton
    public TeamInteractor provideTeamInteractor() {
        return new TeamInteractor();
    }

    @Provides
    @Singleton
    public MatchInteractor provideMatchInteractor() {return new MatchInteractor();}
}
