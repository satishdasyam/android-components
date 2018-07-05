package com.satishdasyam.androidcomponents.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satishdasyam.androidcomponents.R;
import com.satishdasyam.androidcomponents.databinding.FragmentUserListBinding;
import com.satishdasyam.androidcomponents.model.User;
import com.satishdasyam.androidcomponents.view.adapters.UserListAdapter;
import com.satishdasyam.androidcomponents.viewmodel.UserViewModel;

import java.util.List;

public class UserFragment extends Fragment {

    FragmentUserListBinding mBinding;
    UserListAdapter userAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setLayoutManager();
        UserViewModel viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userAdapter = new UserListAdapter(viewModel.getUserListObservable().getValue());
        mBinding.myRecycleList.setAdapter(userAdapter);
        viewModel.getUserListObservable().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (users != null) {
                    userAdapter.setUserList(users);
                }
            }
        });
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mBinding.myRecycleList.setLayoutManager(layoutManager);
    }

}

