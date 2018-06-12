package com.example.falcon_ab.vk_sa_app.di.module;


import com.example.falcon_ab.vk_sa_app.common.manager.MyFragmentManager;
import com.example.falcon_ab.vk_sa_app.common.manager.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {
    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }
}
