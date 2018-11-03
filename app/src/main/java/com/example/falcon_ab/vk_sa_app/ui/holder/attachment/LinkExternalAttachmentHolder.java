package com.example.falcon_ab.vk_sa_app.ui.holder.attachment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.common.utils.Utils;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.LinkExternalViewModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkExternalAttachmentHolder extends BaseViewHolder<LinkExternalViewModel> {

    @BindView(R.id.iv_attachment_picture)
    public ImageView image;

    @BindView(R.id.tv_title)
    public TextView title;

    @BindView(R.id.tv_attachment_url)
    public TextView url;

    public LinkExternalAttachmentHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(LinkExternalViewModel linkExternalViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(linkExternalViewModel.getUrl(), view.getContext());
            }
        });
        title.setText(linkExternalViewModel.getTitle());
        url.setText(linkExternalViewModel.getUrl());

        Glide.with(itemView.getContext()).load(linkExternalViewModel.getImageUrl()).into(image);
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
        title.setText(null);

        image.setImageBitmap(null);
    }
}
