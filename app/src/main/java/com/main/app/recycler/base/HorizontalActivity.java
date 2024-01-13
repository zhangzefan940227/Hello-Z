package com.main.app.recycler.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityHorizontalBinding;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;

public class HorizontalActivity extends AppCompatActivity {

    private ActivityHorizontalBinding horizontalBinding;

    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    BaseAdapter<String> horizontalAdapter = new BaseAdapter<>(null, new BaseAdapter.IBindDataListener<String>() {
        @Override
        public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
            viewHolder.setText(R.id.horizontal_tv, content);
        }

        @Override
        public int getLayoutId(int type) {
            return R.layout.item_list_horizontal;
        }

        @Override
        public int getClickedItemId(int type) {
            return -1;
        }

        @Override
        public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        }
    });

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        horizontalBinding = DataBindingUtil.setContentView(this, R.layout.activity_horizontal);
        initView();
    }

    private void initView() {
        horizontalBinding.horizontalRv.setLayoutManager(layoutManager);
        horizontalBinding.horizontalRv.setHasFixedSize(true);
        horizontalBinding.horizontalRv.setAdapter(horizontalAdapter);
    }
}
