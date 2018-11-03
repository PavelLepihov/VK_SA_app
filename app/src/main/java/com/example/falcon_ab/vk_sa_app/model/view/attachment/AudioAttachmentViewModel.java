package com.example.falcon_ab.vk_sa_app.model.view.attachment;

import android.view.View;

import com.example.falcon_ab.vk_sa_app.common.utils.Utils;
import com.example.falcon_ab.vk_sa_app.model.attachment.Audio;
import com.example.falcon_ab.vk_sa_app.model.view.BaseViewModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;
import com.example.falcon_ab.vk_sa_app.ui.holder.attachment.AudioAttachmentHolder;

public class AudioAttachmentViewModel extends BaseViewModel {

    private String mTitle;
    private String mArtist;

    private String mDuration;


    public AudioAttachmentViewModel(Audio audio) {
        if (audio.getTitle().equals("")) {
            mTitle = "Title";
        } else {
            mTitle = audio.getTitle();
        }

        if (audio.getArtist().equals("")) {
            mArtist = "Various Artist";
        } else {
            mArtist = audio.getArtist();
        }

        mDuration = Utils.parseDuration(audio.getDuration());
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentAudio;
    }

    @Override
    public AudioAttachmentHolder onCreateViewHolder(View view) {
        return new AudioAttachmentHolder(view);
    }


    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getDuration() {
        return mDuration;
    }
}
