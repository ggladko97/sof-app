package com.example.user.myapplication.presenter;

import com.example.user.myapplication.MainActivity;
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
        sofService.searchQuestions(s).enqueue(new Callback<List<Items>>() {
            @Override
            public void onResponse(Call<List<Items>> call, Response<List<Items>> response) {
                List<Items> responseBody = response.body();
                view.updateAdapterDataSet(responseBody);
            }

            @Override
            public void onFailure(Call<List<Items>> call, Throwable t) {
                view.displayError();
            }
        });
    }
}
