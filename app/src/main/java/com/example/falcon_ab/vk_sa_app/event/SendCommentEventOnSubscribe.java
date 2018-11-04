package com.example.falcon_ab.vk_sa_app.event;

import android.support.annotation.NonNull;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKAttachments;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class SendCommentEventOnSubscribe implements ObservableOnSubscribe<VKResponse> {

    private int mOwnerId;
    private int mPostId;
    private String mMessage;
    private VKAttachments attachments;

    public SendCommentEventOnSubscribe(int ownerId, int postId, String message, VKAttachments attachments) {
        this.mOwnerId = ownerId;
        this.mPostId = postId;
        this.mMessage = message;
        this.attachments = attachments;
    }

    @Override
    public void subscribe(@NonNull ObservableEmitter<VKResponse> e) throws Exception {


        VKParameters parameters = new VKParameters();
        parameters.put(VKApiConst.OWNER_ID, mOwnerId);
        parameters.put(VKApiConst.POST_ID, mPostId);
        parameters.put(VKApiConst.ATTACHMENTS, attachments);
        parameters.put(VKApiConst.MESSAGE, mMessage);
        VKRequest request = VKApi.wall().addComment(parameters);
        request.attempts = 10;

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                e.onNext(response);
                e.onComplete();
            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
                e.onError(error.httpError);
            }
        });
    }
}
