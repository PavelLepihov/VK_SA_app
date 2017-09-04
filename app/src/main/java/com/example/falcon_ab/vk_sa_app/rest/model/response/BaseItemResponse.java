package com.example.falcon_ab.vk_sa_app.rest.model.response;


import java.util.ArrayList;
import java.util.List;

public class BaseItemResponse<T> {
    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}