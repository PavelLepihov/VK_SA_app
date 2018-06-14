package com.example.falcon_ab.vk_sa_app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.falcon_ab.vk_sa_app.R;

public class MyPostsFragment extends NewsFeedFragment {
    public MyPostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_my_posts;
    }
}
