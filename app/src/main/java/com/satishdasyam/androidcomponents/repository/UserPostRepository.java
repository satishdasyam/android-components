package com.satishdasyam.androidcomponents.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.satishdasyam.androidcomponents.model.User;
import com.satishdasyam.androidcomponents.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserPostRepository {

    private volatile static UserPostRepository mUserPostRepository;
    private ApiService mRetrofitService;

    public UserPostRepository() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        mRetrofitService = retrofit.create(ApiService.class);
    }


    public static UserPostRepository getInstance() {
        if (mUserPostRepository == null) {
            synchronized (UserPostRepository.class) {
                if (mUserPostRepository == null) {
                    mUserPostRepository = new UserPostRepository();
                }
            }
        }
        return mUserPostRepository;
    }

    public LiveData<List<User>> getUserList() {
        final MutableLiveData<List<User>> data = new MutableLiveData<>();
        mRetrofitService.getUserPosts().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
