package com.main.app.recycler;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityRecyclerBinding;
import com.main.app.recycler.base.GridActivity;
import com.main.app.recycler.base.HorizontalActivity;
import com.main.app.recycler.base.VerticalActivity;
import com.main.app.recycler.base.WaterFallActivity;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding activityRecyclerBinding;

    private List<String> mBaseJumpList;
    private List<String> mAdvanceJumpList;
    private List<Class<?>> mBaseJumpActivity;
    private List<Class<?>> mAdvanceJumpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        init();
    }

    private void init() {
        initDataBase();
        initDataAdvance();
        initViewBase();
        initViewAdvance();
    }

    private void initViewBase() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        BaseAdapter<String> baseAdapter = new BaseAdapter<>(mBaseJumpList, new BaseAdapter.IBindDataListener<String>() {
            @Override
            public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
                viewHolder.setText(R.id.item_recycler_tv, content);
            }

            @Override
            public int getLayoutId(int type) {
                return R.layout.item_recycler;
            }

            @Override
            public int getClickedItemId(int type) {
                return R.id.item_recycler_tv;
            }

            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

            }
        });
        activityRecyclerBinding.recyclerRv.setLayoutManager(layoutManager);
        activityRecyclerBinding.recyclerRv.setAdapter(baseAdapter);
        baseAdapter.setClickListener((view, position) -> {
            jumpActivity(mBaseJumpActivity.get(position));
        });
    }

    private void initDataBase() {
        mBaseJumpList = new ArrayList<>();
        mBaseJumpList.add(getString(R.string.vertical));
        mBaseJumpList.add(getString(R.string.horizontal));
        mBaseJumpList.add(getString(R.string.grid));
        mBaseJumpList.add(getString(R.string.water_fall));

        mBaseJumpActivity = new ArrayList<>();
        mBaseJumpActivity.add(VerticalActivity.class);
        mBaseJumpActivity.add(HorizontalActivity.class);
        mBaseJumpActivity.add(GridActivity.class);
        mBaseJumpActivity.add(WaterFallActivity.class);
    }

    private void initViewAdvance() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        BaseAdapter<String> baseAdapter = new BaseAdapter<>(mAdvanceJumpList, new BaseAdapter.IBindDataListener<String>() {
            @Override
            public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
                viewHolder.setText(R.id.item_recycler_tv, content);
            }

            @Override
            public int getLayoutId(int type) {
                return R.layout.item_recycler;
            }

            @Override
            public int getClickedItemId(int type) {
                return R.id.item_recycler_tv;
            }

            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

            }
        });
        activityRecyclerBinding.recyclerRv2.setLayoutManager(layoutManager);
        activityRecyclerBinding.recyclerRv2.setAdapter(baseAdapter);
        baseAdapter.setClickListener((view, position) -> {
            jumpActivity(mAdvanceJumpActivity.get(position));
        });
    }

    private void initDataAdvance() {
        mAdvanceJumpList = new ArrayList<>();
        mAdvanceJumpList.add("test");

        mAdvanceJumpActivity = new ArrayList<>();
        mAdvanceJumpActivity.add(null);
    }

    public void jumpActivity(final Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }
}