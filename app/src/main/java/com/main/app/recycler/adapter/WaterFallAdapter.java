package com.main.app.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.app.R;

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.WaterFallViewHolder> {

    private int pos = 0;
    @NonNull
    @Override
    public WaterFallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WaterFallViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_waterfall, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WaterFallViewHolder holder, int position) {
        String s = "我是一段文本";
        StringBuilder text = new StringBuilder(s);
        pos = (int) (Math.random() * 10);
        for (int i = 0; i < pos; i++) {
            text.append(s);
        }
        holder.tv.setText(text.toString());
    }

    @Override
    public int getItemViewType(int position) {
        return pos;
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    public static class WaterFallViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        private final ImageView img;
        public WaterFallViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_water_tv);
            img = itemView.findViewById(R.id.water_iv);
        }
    }
}