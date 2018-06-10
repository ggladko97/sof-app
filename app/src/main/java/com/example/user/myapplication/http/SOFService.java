package com.example.user.myapplication.http;

import com.example.user.myapplication.entity.Items;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SOFService {
    @GET("questions")
    Call<Items> searchQuestions(@Query("key") String tag, @Query("order") String order, @Query("sort") String sort, @Query("site") String site, @Query("tagged") String tagged);
}
