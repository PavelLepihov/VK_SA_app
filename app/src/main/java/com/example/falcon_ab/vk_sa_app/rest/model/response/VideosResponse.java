package com.example.falcon_ab.vk_sa_app.rest.model.response;

import com.example.falcon_ab.vk_sa_app.model.attachment.video.Video;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideosResponse {
    public int count;
    @SerializedName("items")
    @Expose
    public List<Video> items;
}
