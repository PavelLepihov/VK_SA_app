package com.example.falcon_ab.vk_sa_app.model;

import com.vk.sdk.api.model.Identifiable;

public interface Owner extends Identifiable{

    String getFullName();
    String getPhoto();
}
