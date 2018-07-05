package com.satishdasyam.androidcomponents.repository;

import com.satishdasyam.androidcomponents.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/posts")
//Later add a param to use DI
    Call<List<User>> getUserPosts();
}
