package com.example.falcon_ab.vk_sa_app.model.view;

import android.view.View;

import com.example.falcon_ab.vk_sa_app.model.WallItem;
import com.example.falcon_ab.vk_sa_app.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel {

    private int mId;

    private String mText;

    private String mAttachmentString;

    private boolean mIsRepost;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost) {
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentsString();
        } else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentsString();
        }
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    public NewsItemBodyHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }


    public String getText() {
        return mText;
    }

    public int getId() {
        return mId;
    }

    public String getAttachmentString() {
        return mAttachmentString;
    }

    @Override
    public boolean isItemDecorator() {
        return true;
    }
}
