package com.example.falcon_ab.vk_sa_app.model.attachment.doc;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PhotoPreview extends RealmObject {
    RealmList<Size> sizes;

    public RealmList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(RealmList<Size> sizes) {
        this.sizes = sizes;
    }
}
