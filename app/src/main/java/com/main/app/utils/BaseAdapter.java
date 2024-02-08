package com.main.app.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.app.interfaces.OnItemClickListener;

import java.util.List;

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private final List<T> mList;
    private final IBindDataListener<T> mBindDataListener;
    private IMoreBindDataListener<T> mMoreBindDataListener;

    private OnItemClickListener clickListener;

    public BaseAdapter(List<T> list, IBindDataListener<T> bindDataListener) {
        this.mList = list;
        this.mBindDataListener = bindDataListener;
    }

    public BaseAdapter(List<T> list, IBindDataListener<T> bindDataListener, IMoreBindDataListener<T> moreBindDataListener) {
        this.mList = list;
        this.mBindDataListener = bindDataListener;
        this.mMoreBindDataListener = moreBindDataListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMoreBindDataListener != null) {
            return mMoreBindDataListener.getItemType(position);
        }
        return 0;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = mBindDataListener.getLayoutId(viewType);
        int clickedItemId = mBindDataListener.getClickedItemId(viewType);
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        BaseViewHolder baseViewHolder = BaseViewHolder.getBaseViewHolder(parent.getContext(), view);

        if (clickedItemId != -1) {
            view.findViewById(clickedItemId).setOnClickListener(v -> {
                clickListener.onItemClick(view, baseViewHolder.getAdapterPosition());
            });
        }
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (mList != null) {
            mBindDataListener.onBindViewHolder(mList.get(position), holder, getItemViewType(position), position);
        }
        mBindDataListener.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 30 : mList.size();
    }


    public void setClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    public interface IBindDataListener<T> {
        void onBindViewHolder(T content, BaseViewHolder viewHolder, int type, int position);

        int getLayoutId(int type);

        int getClickedItemId(int type);

        void onBindViewHolder(@NonNull BaseViewHolder holder, int position);
    }

    public interface IMoreBindDataListener<T> extends IBindDataListener {
        int getItemType(int position);
    }
}

