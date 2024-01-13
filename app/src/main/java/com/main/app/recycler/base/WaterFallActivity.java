package com.main.app.recycler.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityWaterfallBinding;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;

public class WaterFallActivity extends AppCompatActivity {

    private ActivityWaterfallBinding waterfallBinding;
    StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    BaseAdapter<String> waterFullAdapter = new BaseAdapter<>(null, new BaseAdapter.IBindDataListener<String>() {
        @Override
        public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
            viewHolder.setText(R.id.waterfall_rv, content);
        }

        @Override
        public int getLayoutId(int type) {
            return R.layout.item_list_waterfall;
        }

        @Override
        public int getClickedItemId(int type) {
            return -1;
        }

        @Override
        public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
            String s = "我是一段文本";
            StringBuilder text = new StringBuilder(s);
            int pos = (int) (Math.random() * 10);
            for (int i = 0; i < pos; i++) {
                text.append(s);
            }
            holder.setText(R.id.item_water_tv, text.toString());
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        waterfallBinding = DataBindingUtil.setContentView(this, R.layout.activity_waterfall);
        initView();
    }

    private void initView() {
        waterfallBinding.waterfallRv.setLayoutManager(layoutManager);
        waterfallBinding.waterfallRv.setHasFixedSize(true);
        waterfallBinding.waterfallRv.setItemAnimator(null);
        waterfallBinding.waterfallRv.setAdapter(waterFullAdapter);
    }
}
