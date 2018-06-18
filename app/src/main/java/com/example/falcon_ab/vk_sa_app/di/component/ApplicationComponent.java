package com.example.falcon_ab.vk_sa_app.di.component;


import com.example.falcon_ab.vk_sa_app.common.manager.NetworkManager;
import com.example.falcon_ab.vk_sa_app.di.module.ApplicationModule;
import com.example.falcon_ab.vk_sa_app.di.module.ManagerModule;
import com.example.falcon_ab.vk_sa_app.di.module.RestModule;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.BoardPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.InfoPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.MainPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.MembersPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.NewsFeedPresenter;
import com.example.falcon_ab.vk_sa_app.ui.activity.BaseActivity;
import com.example.falcon_ab.vk_sa_app.ui.activity.MainActivity;
import com.example.falcon_ab.vk_sa_app.ui.fragment.NewsFeedFragment;
import com.example.falcon_ab.vk_sa_app.ui.holder.NewsItemBodyHolder;
import com.example.falcon_ab.vk_sa_app.ui.holder.NewsItemFooterHolder;

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
    //holders
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
    //presenters
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);
    void inject(BoardPresenter presenter);
    void inject(InfoPresenter presenter);
    //managers
    void inject(NetworkManager manager);
}
