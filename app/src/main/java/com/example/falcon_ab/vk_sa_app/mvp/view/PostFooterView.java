package com.example.falcon_ab.vk_sa_app.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.falcon_ab.vk_sa_app.model.WallItem;
import com.example.falcon_ab.vk_sa_app.model.view.counter.LikeCounterViewModel;

public interface PostFooterView extends MvpView {
    void like(LikeCounterViewModel likes);

    void openComments(WallItem wallItem);
}
