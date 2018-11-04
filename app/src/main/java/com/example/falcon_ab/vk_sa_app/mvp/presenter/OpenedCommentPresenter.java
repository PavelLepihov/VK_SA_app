package com.example.falcon_ab.vk_sa_app.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.common.utils.VkListHelper;
import com.example.falcon_ab.vk_sa_app.model.CommentItem;
import com.example.falcon_ab.vk_sa_app.model.view.BaseViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.CommentFooterViewModel;
import com.example.falcon_ab.vk_sa_app.model.view.OpenedPostHeaderViewModel;
import com.example.falcon_ab.vk_sa_app.mvp.view.BaseFeedView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.realm.Realm;

@InjectViewState
public class OpenedCommentPresenter extends BaseFeedPresenter<BaseFeedView> {

    int id;

    public OpenedCommentPresenter() {
        MyApplication.getApplicationComponent().inject(this);

    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return createObservable();

    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return createObservable();
    }


    private Observable<BaseViewModel> createObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .retry(2)
                .flatMap(commentItem -> {
                    List<BaseViewModel> list = new ArrayList<>();
                    List<BaseViewModel> forwardedList = new ArrayList<>();

                    list.add(new OpenedPostHeaderViewModel(commentItem));

                    list.addAll(VkListHelper.getAttachmentVkItems(commentItem.getAttachments()));

                    list.add(new CommentFooterViewModel(commentItem));

                    return Observable.fromIterable(list).concatWith(Observable.fromIterable(forwardedList));
                });
    }



    public Callable<CommentItem> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            CommentItem commentItem = realm.where(CommentItem.class).equalTo("id", id).findFirst();

            return realm.copyFromRealm(commentItem);
        };
    }

    public void setId(int id) {
        this.id = id;
    }
}
