package com.example.falcon_ab.vk_sa_app;

import android.app.Application;

import com.example.falcon_ab.vk_sa_app.di.component.ApplicationComponent;
import com.example.falcon_ab.vk_sa_app.di.component.DaggerApplicationComponent;
import com.example.falcon_ab.vk_sa_app.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
        initComponent();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
