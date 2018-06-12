package com.example.falcon_ab.vk_sa_app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.BaseFeedPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.NewsFeedPresenter;
import com.example.falcon_ab.vk_sa_app.rest.api.WallApi;

import javax.inject.Inject;


public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;
    @InjectPresenter
    NewsFeedPresenter mPresenter;



    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_feed;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}
