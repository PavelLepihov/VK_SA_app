package com.example.falcon_ab.vk_sa_app.di.module;

import com.example.falcon_ab.vk_sa_app.rest.RestClient;
import com.example.falcon_ab.vk_sa_app.rest.api.AccountApi;
import com.example.falcon_ab.vk_sa_app.rest.api.BoardApi;
import com.example.falcon_ab.vk_sa_app.rest.api.GroupsApi;
import com.example.falcon_ab.vk_sa_app.rest.api.UsersApi;
import com.example.falcon_ab.vk_sa_app.rest.api.VideoApi;
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
    @Provides
    @Singleton
    public UsersApi provideUsersApi() {
        return mRestClient.createService(UsersApi.class);
    }
    @Provides
    @Singleton
    public GroupsApi provideGroupsApi() {
        return mRestClient.createService(GroupsApi.class);
    }
    @Provides
    @Singleton
    public BoardApi provideBoardApi() {
        return mRestClient.createService(BoardApi.class);
    }
    @Provides
    @Singleton
    public VideoApi provideVideoApi() {
        return mRestClient.createService(VideoApi.class);
    }
    @Provides
    @Singleton
    public AccountApi provideAccountApi() {
        return mRestClient.createService(AccountApi.class);
    }
}
