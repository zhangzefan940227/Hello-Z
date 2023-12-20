package com.main.app.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityMainBinding;
import com.main.app.databinding.ActivityRecyclerBinding;
import com.main.app.menu.MainAdapter;
import com.main.app.recycler.base.GridActivity;
import com.main.app.recycler.base.HorizontalActivity;
import com.main.app.recycler.base.VerticalActivity;
import com.main.app.recycler.base.WaterFallActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding activityRecyclerBinding;

    private RecyclerAdapter mRecyclerAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<String> mRecyclerJumpToList;
    private List<Class<?>> mRecyclerJumpToActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        initData();
        initView();
    }


    private void initView() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerAdapter = new RecyclerAdapter(mRecyclerJumpToList);
        activityRecyclerBinding.recyclerRv.setLayoutManager(mLayoutManager);
        activityRecyclerBinding.recyclerRv.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener((view, position) -> {
            jumpActivity(mRecyclerJumpToActivity.get(position));
        });
    }

    private void initData() {
        mRecyclerJumpToList = new ArrayList<>();
        mRecyclerJumpToList.add(getString(R.string.vertical));
        mRecyclerJumpToList.add(getString(R.string.horizontal));
        mRecyclerJumpToList.add(getString(R.string.grid));
        mRecyclerJumpToList.add(getString(R.string.water_fall));

        mRecyclerJumpToActivity = new ArrayList<>();
        mRecyclerJumpToActivity.add(VerticalActivity.class);
        mRecyclerJumpToActivity.add(HorizontalActivity.class);
        mRecyclerJumpToActivity.add(GridActivity.class);
        mRecyclerJumpToActivity.add(WaterFallActivity.class);
    }

    public void jumpActivity(final Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }
}