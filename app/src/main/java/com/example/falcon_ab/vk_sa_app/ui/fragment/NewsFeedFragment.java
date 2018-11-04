package com.example.falcon_ab.vk_sa_app.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.BaseFeedPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.NewsFeedPresenter;
import com.example.falcon_ab.vk_sa_app.rest.api.WallApi;
import com.example.falcon_ab.vk_sa_app.ui.activity.CreatePostActivity;

import javax.inject.Inject;


public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;
    @InjectPresenter
    NewsFeedPresenter mPresenter;

    public NewsFeedFragment() {
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

    @Override
    public void onResume() {
        super.onResume();
        getBaseActivity().mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), CreatePostActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public boolean needFab() {
        return true;
    }
}
