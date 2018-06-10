package com.example.user.myapplication.presenter;

import com.example.user.myapplication.entity.Items;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void updateAdapterDataSet(Items responseBody);
        void displayError();
    }

    interface Presenter extends BasePresenter<View> {
        void searchQuestions(String s);
    }
}
