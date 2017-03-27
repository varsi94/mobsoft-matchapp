package com.mobsoft.matchapp;

import com.mobsoft.matchapp.ui.UiModule;
import com.mobsoft.matchapp.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UiModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
}
