package com.example.falcon_ab.vk_sa_app.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.falcon_ab.vk_sa_app.model.Profile;
import com.example.falcon_ab.vk_sa_app.ui.fragment.BaseFragment;


public interface MainView extends MvpView {
    void startSignIn();

    void signedId();

    void showCurrentUser(Profile profile);

    void showFragmentFromDrawer(BaseFragment baseFragment);
}
