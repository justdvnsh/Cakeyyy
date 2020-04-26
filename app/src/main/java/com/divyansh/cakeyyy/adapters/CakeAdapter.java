package com.divyansh.cakeyyy.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.cakeViewHolder> {
    @NonNull
    @Override
    public CakeAdapter.cakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CakeAdapter.cakeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class cakeViewHolder extends RecyclerView.ViewHolder{
        public cakeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
