package com.example.user.myapplication.presenter;

import com.example.user.myapplication.entity.Items;

import java.util.List;

public interface MainActivityContract {
    interface View {
//        void loadMainScreen();
        void displaySearchResult(List<Items> result);

        void updateAdapterDataSet(List<Items> responseBody);

        void displayError();
    }

    interface Presenter extends BasePresenter<View> {
        void searchQuestions(String s);
    }
}
