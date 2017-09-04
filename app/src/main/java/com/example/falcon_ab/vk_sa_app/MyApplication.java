package com.example.falcon_ab.vk_sa_app;

import android.app.Application;

import com.example.falcon_ab.vk_sa_app.di.component.ApplicationComponent;

import com.example.falcon_ab.vk_sa_app.di.component.DaggerApplicationComponent;
import com.example.falcon_ab.vk_sa_app.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;


public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
        initComponent();
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
