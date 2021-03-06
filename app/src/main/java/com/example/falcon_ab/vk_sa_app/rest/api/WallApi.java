package com.example.falcon_ab.vk_sa_app.rest.api;


import com.example.falcon_ab.vk_sa_app.model.CommentItem;
import com.example.falcon_ab.vk_sa_app.rest.model.response.Full;
import com.example.falcon_ab.vk_sa_app.rest.model.response.GetWallByIdResponse;
import com.example.falcon_ab.vk_sa_app.rest.model.response.ItemsWithSendersResponse;
import com.example.falcon_ab.vk_sa_app.rest.model.response.WallGetResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Observable<WallGetResponse> get(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_BY_ID)
    Observable<GetWallByIdResponse> getById(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_COMMENTS)
    Observable<Full<ItemsWithSendersResponse<CommentItem>>> getComments(@QueryMap Map<String, String> map);
}
