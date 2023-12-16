package com.main.app.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.app.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }


    public static class GridViewHolder extends RecyclerView.ViewHolder {

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
