package com.satishdasyam.androidcomponents.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.satishdasyam.androidcomponents.R;
import com.satishdasyam.androidcomponents.databinding.UserListCellBinding;
import com.satishdasyam.androidcomponents.model.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    List<User> userList;

    public UserListAdapter(List<User> list) {
        this.userList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserListCellBinding cellBinding = DataBindingUtil.inflate(LayoutInflater.
                from(parent.getContext()), R.layout.user_list_cell, parent, false);
        return new ViewHolder(cellBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cellBinding.setUser(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        this.notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        UserListCellBinding cellBinding;

        public ViewHolder(UserListCellBinding cellBinding) {
            super(cellBinding.getRoot());
            this.cellBinding = cellBinding;
        }
    }
}
