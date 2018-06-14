package com.example.falcon_ab.vk_sa_app.rest.api;

import com.example.falcon_ab.vk_sa_app.model.Member;
import com.example.falcon_ab.vk_sa_app.rest.model.response.BaseItemResponse;
import com.example.falcon_ab.vk_sa_app.rest.model.response.Full;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GroupsApi {

    @GET(ApiMethods.GROUPS_GET_MEMBERS)
    Observable<Full<BaseItemResponse<Member>>> getMembers(@QueryMap Map<String, String> map);

}
