package com.main.app.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.main.app.R;
import com.main.app.animation.AnimationActivity;
import com.main.app.databinding.ActivityMainBinding;
import com.main.app.recycler.RecyclerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private LinearLayoutManager mLayoutManager;
    private MainAdapter mMainAdapter;
    private List<String> mJumpToList;
    private List<Class<?>> mJumpToActivity;

//    private Map<View, Class<?>> mJumpToMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initData();
        initRecyclerView();
    }

    public void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mMainAdapter = new MainAdapter(mJumpToList);
        mainBinding.mainRv.setLayoutManager(mLayoutManager);
        mainBinding.mainRv.setAdapter(mMainAdapter);
        mMainAdapter.setClickListener((view, position) -> {
            jumpActivity(mJumpToActivity.get(position));
        });
    }

    public void initData() {
        mJumpToList = new ArrayList<>();
        mJumpToList.add(getString(R.string.property_animation));
        mJumpToList.add(getString(R.string.recycler_view));

        mJumpToActivity = new ArrayList<>();
        mJumpToActivity.add(AnimationActivity.class);
        mJumpToActivity.add(RecyclerActivity.class);
    }

    public void jumpActivity(final Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }
}