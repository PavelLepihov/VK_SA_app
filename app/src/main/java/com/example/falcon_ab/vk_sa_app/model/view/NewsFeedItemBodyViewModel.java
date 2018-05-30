package com.example.falcon_ab.vk_sa_app.model.view;

import android.view.View;

import com.example.falcon_ab.vk_sa_app.model.WallItem;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;
import com.example.falcon_ab.vk_sa_app.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel {

    private int mId;
    private String mText;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }


    public String getText() {
        return mText;
    }

    public int getId() {
        return mId;
    }
}
