package com.main.app.recycler.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityVerticalBinding;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;

public class VerticalActivity extends AppCompatActivity {

    private ActivityVerticalBinding verticalBinding;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    BaseAdapter<String> verticalAdapter = new BaseAdapter<>(null, new BaseAdapter.IBindDataListener<String>() {
        @Override
        public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
            viewHolder.setText(R.id.vertical_rv, content);
        }

        @Override
        public int getLayoutId(int type) {
            return R.layout.item_list_vertical;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verticalBinding = DataBindingUtil.setContentView(this, R.layout.activity_vertical);
        initView();
    }

    private void initView() {
        verticalBinding.verticalRv.setLayoutManager(layoutManager);
        verticalBinding.verticalRv.setHasFixedSize(true);
        verticalBinding.verticalRv.setAdapter(verticalAdapter);
    }
}
