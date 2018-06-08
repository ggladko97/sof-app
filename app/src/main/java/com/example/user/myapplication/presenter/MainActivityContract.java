package com.example.user.myapplication.presenter;

import com.example.user.myapplication.entity.SOFResponse;

import java.util.List;

public interface MainActivityContract {
    interface View {
//        void loadMainScreen();
        void displaySearchResult(List<SOFResponse> result);
    }

    interface Presenter extends BasePresenter<View> {
        void searchQuestions();
    }
}
