package com.mobsoft.matchapp.ui;

import android.content.Context;

import com.mobsoft.matchapp.ui.main.MainPresenter;

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

}
