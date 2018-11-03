package com.example.falcon_ab.vk_sa_app.ui.holder.attachment;

import android.view.View;
import android.widget.TextView;

import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.common.utils.Utils;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.DocAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DocAttachmentHolder extends BaseViewHolder<DocAttachmentViewModel> {

    @BindView(R.id.tv_attachment_title)
    public TextView title;

    @BindView(R.id.tv_attachment_ext)
    public TextView ext;

    @BindView(R.id.tv_attachment_size)
    public TextView size;


    public DocAttachmentHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(DocAttachmentViewModel docAttachmentViewModel) {
        if (docAttachmentViewModel.needClick) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utils.openUrlInActionView(docAttachmentViewModel.getmUrl(), view.getContext());
                }
            });
        }

        title.setText(docAttachmentViewModel.getTitle());

        size.setText(docAttachmentViewModel.getSize());

        ext.setText(docAttachmentViewModel.getExt());
    }

    @Override
    public void unbindViewHolder() {

        itemView.setOnClickListener(null);

        title.setText(null);

        size.setText(null);

        ext.setText(null);
    }
}
