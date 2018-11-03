package com.example.falcon_ab.vk_sa_app.model.view.attachment;

import android.view.View;

import com.example.falcon_ab.vk_sa_app.model.attachment.Link;
import com.example.falcon_ab.vk_sa_app.model.view.BaseViewModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;
import com.example.falcon_ab.vk_sa_app.ui.holder.attachment.LinkAttachmentViewHolder;

public class LinkAttachmentViewModel extends BaseViewModel {

    private String mTitle;
    private String mUrl;

    public LinkAttachmentViewModel(Link link) {

        if (link.getTitle() == null || link.getTitle().equals("")) {
            if (link.getName() != null) {
                mTitle = link.getName();
            } else {
                mTitle = "Link";
            }
        } else {
            mTitle = link.getTitle();
        }

        mUrl = link.getUrl();
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentLink;
    }

    @Override
    public LinkAttachmentViewHolder onCreateViewHolder(View view) {
        return new LinkAttachmentViewHolder(view);
    }


    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }
}
