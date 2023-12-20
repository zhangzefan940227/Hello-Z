package com.main.app.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.app.R;
import com.main.app.utils.OnItemClickListener;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private final List<String> jumpToList;
    private OnItemClickListener clickListener;
    public MainAdapter(List<String> jumpToList) {
        this.jumpToList = jumpToList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);
        view.findViewById(R.id.item_main_tv).setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onItemClick(view, mainViewHolder.getAdapterPosition());
            }
        });
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.textView.setText(jumpToList.get(position));
    }

    @Override
    public int getItemCount() {
        return jumpToList.size();
    }

    public void setClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_main_tv);
        }
    }
}
