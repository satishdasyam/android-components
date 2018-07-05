package com.satishdasyam.androidcomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.satishdasyam.androidcomponents.model.User;
import com.satishdasyam.androidcomponents.repository.UserPostRepository;

import java.util.List;

public class UserViewModel extends ViewModel {

    private LiveData<List<User>> mUserListObservable;

    public UserViewModel() {
        mUserListObservable = UserPostRepository.getInstance().getUserList();
    }

    public LiveData<List<User>> getUserListObservable() {
        return mUserListObservable;
    }
}
