package com.example.falcon_ab.vk_sa_app.di.module;


import com.example.falcon_ab.vk_sa_app.ui.activity.common.manager.MyFragmentManager;

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
}
