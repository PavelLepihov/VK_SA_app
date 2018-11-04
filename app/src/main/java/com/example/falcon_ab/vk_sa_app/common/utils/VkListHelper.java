package com.example.falcon_ab.vk_sa_app.common.utils;

import com.example.falcon_ab.vk_sa_app.model.CommentItem;
import com.example.falcon_ab.vk_sa_app.model.Owner;
import com.example.falcon_ab.vk_sa_app.model.WallItem;
import com.example.falcon_ab.vk_sa_app.model.attachment.ApiAttachment;
import com.example.falcon_ab.vk_sa_app.model.view.BaseViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.AudioAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.DocAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.DocImageAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.ImageAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.LinkAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.LinkExternalViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.PageAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.attachment.VideoAttachmentViewModel;
import com.example.falcon_ab.vk_sa_app.rest.model.response.ItemsWithSendersResponse;
import com.vk.sdk.api.model.VKAttachments;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class VkListHelper {
    public static List<WallItem> getWallList(ItemsWithSendersResponse<WallItem> response) {
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            wallItem.setAttachmentsString(Utils.convertAttachmentsToFontIcons(wallItem.getAttachments()));

            if (wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());
                wallItem.getSharedRepost().setAttachmentsString(Utils.convertAttachmentsToFontIcons(
                        wallItem.getSharedRepost().getAttachments()
                ));
            }
        }
        return wallItems;
    }

    public static List<BaseViewModel> getAttachmentVkItems(List<ApiAttachment> attachments) {

        List<BaseViewModel> attachmentVhItems = new ArrayList<>();
        for (ApiAttachment attachment : attachments) {

            switch (attachment.getType()) {
                case VKAttachments.TYPE_PHOTO:
                    attachmentVhItems.add(new ImageAttachmentViewModel(attachment.getPhoto()));
                    break;

                case VKAttachments.TYPE_AUDIO:
                    attachmentVhItems.add(new AudioAttachmentViewModel(attachment.getAudio()));
                    break;

                case VKAttachments.TYPE_VIDEO:
                    attachmentVhItems.add(new VideoAttachmentViewModel(attachment.getVideo()));
                    break;

                case VKAttachments.TYPE_DOC:
                    if (attachment.getDoc().getPreview() != null) {
                        attachmentVhItems.add(new DocImageAttachmentViewModel(attachment.getDoc()));
                    } else {
                        attachmentVhItems.add(new DocAttachmentViewModel(attachment.getDoc()));
                    }
                    break;

                case VKAttachments.TYPE_LINK:
                    if (attachment.getLink().getIsExternal() == 1) {
                        attachmentVhItems.add(new LinkExternalViewModel(attachment.getLink()));
                    } else {
                        attachmentVhItems.add(new LinkAttachmentViewModel(attachment.getLink()));
                    }
                    break;

                case "page":
                    attachmentVhItems.add(new PageAttachmentViewModel(attachment.getPage()));
                    break;

                default:
                    throw new NoSuchElementException("Attachment type " + attachment.getType() + " is not supported.");
            }
        }
        return attachmentVhItems;
    }

    public static List<CommentItem> getCommentsList(ItemsWithSendersResponse<CommentItem> response, boolean isFromTopic) {
        List<CommentItem> commentItems = response.items;

        for (CommentItem commentItem : commentItems) {
            Owner sender = response.getSender(commentItem.getFromId());
            commentItem.setSenderName(sender.getFullName());
            commentItem.setSenderPhoto(sender.getPhoto());

            commentItem.setIsFromTopic(isFromTopic);

            commentItem.setAttachmentsString(Utils
                    .convertAttachmentsToFontIcons(commentItem.getAttachments()));
        }
        return commentItems;
    }
}
