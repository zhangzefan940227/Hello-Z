package com.main.app.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.app.R;
import com.main.app.utils.OnItemClickListener;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private final List<String> recyclerJumpToList;
    private OnItemClickListener clickListener;
    public RecyclerAdapter(List<String> recyclerJumpToList) {
        this.recyclerJumpToList = recyclerJumpToList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        RecyclerAdapter.RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        view.findViewById(R.id.item_recycler_tv).setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onItemClick(view, recyclerViewHolder.getAdapterPosition());
            }
        });
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textView.setText(recyclerJumpToList.get(position));

    }

    @Override
    public int getItemCount() {
        return recyclerJumpToList.size();
    }

    public void setClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_recycler_tv);
        }
    }
}
