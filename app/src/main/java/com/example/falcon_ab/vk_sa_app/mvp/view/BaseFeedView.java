package com.example.falcon_ab.vk_sa_app.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.falcon_ab.vk_sa_app.model.view.BaseViewModel;

import java.util.List;

public interface BaseFeedView extends MvpView {
    void showRefreshing();

    void hideRefreshing();


    void showListProgress();

    void hideListProgress();


    void showError(String message);


    void setItems(List<BaseViewModel> items);

    void addItems(List<BaseViewModel> items);
}
