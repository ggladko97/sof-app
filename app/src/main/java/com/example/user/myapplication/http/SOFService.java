package com.example.user.myapplication.http;

import com.example.user.myapplication.entity.Items;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SOFService {
    @GET("{tag}")
    Call<List<Items>> searchQuestions(@Path("tag") String tag);
}
