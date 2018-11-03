package com.example.falcon_ab.vk_sa_app.ui.holder.attachment;

import android.view.View;
import android.widget.TextView;

import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.common.utils.Utils;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.LinkAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkAttachmentViewHolder extends BaseViewHolder<LinkAttachmentViewModel> {

    @BindView(R.id.tv_title)
    public TextView title;

    @BindView(R.id.tv_attachment_url)
    public TextView url;

    public LinkAttachmentViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(LinkAttachmentViewModel linkAttachmentViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(linkAttachmentViewModel.getUrl(), view.getContext());
            }
        });
        title.setText(linkAttachmentViewModel.getTitle());
        url.setText(linkAttachmentViewModel.getUrl());
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
        title.setText(null);
    }
}
