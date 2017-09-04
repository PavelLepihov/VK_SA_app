package com.example.falcon_ab.vk_sa_app.di.module;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }
    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }
}
