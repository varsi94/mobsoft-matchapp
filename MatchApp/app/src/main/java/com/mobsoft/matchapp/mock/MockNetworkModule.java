package com.mobsoft.matchapp.mock;

import com.mobsoft.matchapp.mock.interceptors.MockInterceptor;
import com.mobsoft.matchapp.network.NetworkModule;
import com.mobsoft.matchapp.network.api.MatchesApi;
import com.mobsoft.matchapp.network.api.TeamsApi;
import com.mobsoft.matchapp.network.api.UsersApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by varsi on 2017. 05. 14..
 */

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder providerOkHttpClientBuilder() {
        return networkModule.provideOkHttpBuilder();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        builder.interceptors().add(new MockInterceptor());
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public MatchesApi provideMatchesApi(Retrofit retrofit) {
        return networkModule.provideMatchesApi(retrofit);
    }

    @Provides
    @Singleton
    public TeamsApi provideTeamsApi(Retrofit retrofit) {
        return networkModule.provideTeamsApi(retrofit);
    }

    @Provides
    @Singleton
    public UsersApi provideUsersApi(Retrofit retrofit) {
        return networkModule.provideUsersApi(retrofit);
    }
}
