package com.example.falcon_ab.vk_sa_app.ui.holder.attachment;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.common.manager.MyFragmentManager;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.ImageAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.ui.activity.BaseActivity;
import com.example.falcon_ab.vk_sa_app.ui.fragment.ImageFragment;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageAttachmentHolder extends BaseViewHolder<ImageAttachmentViewModel> {


    @BindView(R.id.iv_attachment_image)
    public ImageView image;

    @Inject
    MyFragmentManager mFragmentManager;


    public ImageAttachmentHolder(View itemView) {
        super(itemView);

        MyApplication.getApplicationComponent().inject(this);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ImageAttachmentViewModel imageAttachmentViewModel) {

        if (imageAttachmentViewModel.needClick) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mFragmentManager.addFragment((BaseActivity) itemView.getContext(),
                            ImageFragment.newInstance(imageAttachmentViewModel.getPhotoUrl()), R.id.main_wrapper);
                }
            });
        }

        Glide.with(itemView.getContext()).load(imageAttachmentViewModel.getPhotoUrl()).into(image);


    }

    @Override
    public void unbindViewHolder() {

        itemView.setOnClickListener(null);
        image.setImageBitmap(null);
    }

}
