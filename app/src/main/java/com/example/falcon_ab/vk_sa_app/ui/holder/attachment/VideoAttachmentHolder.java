package com.example.falcon_ab.vk_sa_app.ui.holder.attachment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.common.utils.Utils;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.VideoAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.rest.api.VideoApi;
import com.example.falcon_ab.vk_sa_app.rest.model.request.VideoGetRequestModel;
import com.example.falcon_ab.vk_sa_app.ui.holder.BaseViewHolder;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class VideoAttachmentHolder extends BaseViewHolder<VideoAttachmentViewModel> {

    @BindView(R.id.tv_attachment_video_title)
    public TextView title;

    @BindView(R.id.tv_attachment_video_duration)
    public TextView duration;

    @BindView(R.id.iv_attachment_video_picture)
    public ImageView image;

    @BindView(R.id.tv_views_count)
    public TextView views;

    @Inject
    VideoApi mVideoApi;

    public VideoAttachmentHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(VideoAttachmentViewModel videoAttachmentViewModel) {

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mVideoApi.get(new VideoGetRequestModel(videoAttachmentViewModel.getOwnerId(), videoAttachmentViewModel.getId()).toMap())

                        .flatMap(videosResponseFull -> Observable.fromIterable(videosResponseFull.response.items))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(newVideo -> {
                            String url = newVideo.getFiles() == null ? newVideo.getPlayer() : newVideo.getFiles().getExternal();

                            Utils.openUrlInActionView(url, view.getContext());
                        });

            }
        });

        title.setText(videoAttachmentViewModel.getTitle());
        views.setText(videoAttachmentViewModel.getViewCount());
        duration.setText(videoAttachmentViewModel.getDuration());

        Glide.with(itemView.getContext()).load(videoAttachmentViewModel.getImageUrl()).into(image);
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);

        title.setText(null);
        views.setText(null);
        duration.setText(null);

        image.setImageBitmap(null);
    }


}
