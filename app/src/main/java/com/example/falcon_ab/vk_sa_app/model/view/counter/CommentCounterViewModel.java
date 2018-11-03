package com.example.falcon_ab.vk_sa_app.model.view.counter;

import com.example.falcon_ab.vk_sa_app.model.countable.Comments;

public class CommentCounterViewModel extends CounterViewModel{

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
