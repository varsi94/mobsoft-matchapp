package com.mobsoft.matchapp.matchapp;

import com.mobsoft.matchapp.MobSoftApplicationComponent;
import com.mobsoft.matchapp.interactor.InteractorModule;
import com.mobsoft.matchapp.interactor.InteractorModule_ProvideTeamInteractorFactory;
import com.mobsoft.matchapp.matchapp.repository.TestRepositoryModule;
import com.mobsoft.matchapp.mock.MockNetworkModule;
import com.mobsoft.matchapp.ui.UiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by varsi on 2017. 05. 14..
 */
@Singleton
@Component(modules = {TestRepositoryModule.class, InteractorModule.class, TestModule.class, MockNetworkModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
