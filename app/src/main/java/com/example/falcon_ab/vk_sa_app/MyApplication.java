package com.example.falcon_ab.vk_sa_app;

import android.app.Application;

import com.vk.sdk.VKSdk;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
