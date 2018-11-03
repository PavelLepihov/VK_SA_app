package com.example.falcon_ab.vk_sa_app.model.view.attachment;

import android.view.View;

import com.example.falcon_ab.vk_sa_app.common.utils.Utils;
import com.example.falcon_ab.vk_sa_app.model.attachment.video.Video;
import com.example.falcon_ab.vk_sa_app.model.view.BaseViewModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;
import com.example.falcon_ab.vk_sa_app.ui.holder.attachment.VideoAttachmentHolder;

public class VideoAttachmentViewModel extends BaseViewModel {

    private int id;
    private int ownerId;

    private String mTitle;
    private String mViewCount;
    private String mDuration;
    private String mImageUrl;

    public VideoAttachmentViewModel(Video video) {
        this.id = video.getId();
        this.ownerId = video.getOwnerId();

        if (video.getTitle().equals("")) {
            mTitle = "Video";
        } else {
            mTitle = video.getTitle();
        }

        mViewCount = Utils.formatViewsCount(video.getViews());

        mDuration = Utils.parseDuration(video.getDuration());

        mImageUrl = video.getPhoto320();
    }



    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentVideo;
    }

    @Override
    public VideoAttachmentHolder onCreateViewHolder(View view) {
        return new VideoAttachmentHolder(view);
    }


    public int getOwnerId() {
        return ownerId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getViewCount() {
        return mViewCount;
    }

    public String getDuration() {
        return mDuration;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
