package com.mobsoft.matchapp.matchapp.repository;

import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by varsi on 2017. 05. 14..
 */

@Module
public class TestRepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
