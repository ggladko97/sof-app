package com.example.user.myapplication.presenter;

import android.util.Log;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.entity.Item;
import com.example.user.myapplication.entity.Items;
import com.example.user.myapplication.http.RetrofitFactory;
import com.example.user.myapplication.http.SOFService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivity view;
    private SOFService sofService;
    private static final String SOF_APP_KEY = "e)qbQKklgtQv*9T9AsxdXQ((";

    @Override
    public void bindView(MainActivityContract.View view) {
        this.view = (MainActivity) view;
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        sofService = retrofit.create(SOFService.class);
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void searchQuestions(String s) {
        //retrofit call
        //view.update
        sofService.searchQuestions(SOF_APP_KEY,"desc", "activity", "stackoverflow", s).enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Log.i("MainActivityPresenter", "Request successful at: " + call.request().url().toString());
                Items responseBody = response.body();
                view.updateAdapterDataSet(responseBody);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Log.e("MainActivityPresenter", t.getMessage());
                view.displayError();
            }
        });
    }
}
