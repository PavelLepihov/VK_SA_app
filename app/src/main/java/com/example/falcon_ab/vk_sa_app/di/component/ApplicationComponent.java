package com.example.falcon_ab.vk_sa_app.di.component;


import com.example.falcon_ab.vk_sa_app.di.module.ApplicationModule;
import com.example.falcon_ab.vk_sa_app.di.module.ManagerModule;
import com.example.falcon_ab.vk_sa_app.di.module.RestModule;
import com.example.falcon_ab.vk_sa_app.ui.activity.BaseActivity;
import com.example.falcon_ab.vk_sa_app.ui.activity.MainActivity;
import com.example.falcon_ab.vk_sa_app.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    // activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);
    // fragments
    void inject(NewsFeedFragment fragment);
}
