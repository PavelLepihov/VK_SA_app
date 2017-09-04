package com.example.falcon_ab.vk_sa_app.di.module;

import com.example.falcon_ab.vk_sa_app.rest.RestClient;
import com.example.falcon_ab.vk_sa_app.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {
    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }
    @Singleton
    @Provides
    public RestClient provideRestClient() {
        return mRestClient;
    }
    @Singleton
    @Provides
    public WallApi provideWallApi() {
        return mRestClient.createService(WallApi.class);
    }
}
