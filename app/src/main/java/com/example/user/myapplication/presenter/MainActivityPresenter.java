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
    private Retrofit retrofit;
    private SOFService sofService;

    @Override
    public void bindView(MainActivityContract.View view) {
        this.view = (MainActivity) view;
        retrofit = RetrofitFactory.getRetrofit();
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
        sofService.searchQuestions("e)qbQKklgtQv*9T9AsxdXQ((","desc", "activity", "stackoverflow", s).enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Log.i("MAP: ", "SUCCESS " + call.request().url().toString());

                if(response.body() != null) {
                    Log.i("MAP", "response is not null " +((Items) response.body()).toString());
                }
//                Log.i("MAP items: ", items.toString());
                Items responseBody = response.body();
                view.updateAdapterDataSet(responseBody);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Log.e("MAP: ", t.getMessage());
                view.displayError();
            }
        });
    }
}
