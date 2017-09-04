package com.example.falcon_ab.vk_sa_app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.falcon_ab.vk_sa_app.CurrentUser;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.rest.api.WallApi;
import com.example.falcon_ab.vk_sa_app.rest.model.response.BaseItemResponse;
import com.example.falcon_ab.vk_sa_app.rest.model.response.Full;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

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
        mWallApi.get("-86529522", CurrentUser.getAccessToken(), 1, "5.67").enqueue(new Callback<Full<BaseItemResponse>>() {
            @Override
            public void onResponse(Call<Full<BaseItemResponse>> call, Response<Full<BaseItemResponse>> response) {
                Toast.makeText(getActivity(), "Count: "
                        + response.body().response.getCount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Full<BaseItemResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_feed;
    }

}
