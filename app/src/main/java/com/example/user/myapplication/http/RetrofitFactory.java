package com.example.user.myapplication.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.2/questions?key=e)qbQKklgtQv*9T9AsxdXQ((&site=stackoverflow&order=desc&sort=activity&filter=default&tagged=")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
