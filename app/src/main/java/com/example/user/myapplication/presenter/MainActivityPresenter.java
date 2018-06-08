package com.example.user.myapplication.presenter;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.entity.SOFResponse;

import java.util.List;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivity view;

    @Override
    public void bindView(MainActivityContract.View view) {
        this.view = (MainActivity) view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void searchQuestions() {
        //retrofit call
        //view.update
    }
}
