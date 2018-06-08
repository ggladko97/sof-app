package com.example.user.myapplication.presenter;

public interface BasePresenter<V> {
    void bindView(V view);
    void unbindView();
}
