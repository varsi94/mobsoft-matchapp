package com.mobsoft.matchapp.network;

import com.mobsoft.matchapp.network.api.MatchesApi;
import com.mobsoft.matchapp.network.api.TeamsApi;
import com.mobsoft.matchapp.network.api.UsersApi;
import com.mobsoft.matchapp.utils.GsonHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpBuilder(){
        return new OkHttpClient().newBuilder();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder){
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public UsersApi provideUsersApi(Retrofit retrofit) {
        return retrofit.create(UsersApi.class);
    }

    @Provides
    @Singleton
    public MatchesApi provideMatchesApi(Retrofit retrofit) {
        return retrofit.create(MatchesApi.class);
    }

    @Provides
    @Singleton
    public TeamsApi provideTeamsApi(Retrofit retrofit){
        return retrofit.create(TeamsApi.class);
    }
}
