package com.main.app.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.main.app.R;
import com.main.app.animation.AnimationActivity;
import com.main.app.databinding.ActivityMainBinding;
import com.main.app.recycler.RecyclerActivity;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private LinearLayoutManager mLayoutManager;
    private BaseAdapter<String> baseAdapter;
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
        mainBinding.mainRv.setLayoutManager(mLayoutManager);

        baseAdapter = new BaseAdapter<>(mJumpToList, new BaseAdapter.IBindDataListener<String>() {
            @Override
            public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
                viewHolder.setText(R.id.item_main_tv, content);
            }

            @Override
            public int getLayoutId(int type) {
                return R.layout.item_main;
            }

            @Override
            public int getClickedItemId(int type) {
                return R.id.item_main_tv;
            }

            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

            }
        });
        mainBinding.mainRv.setAdapter(baseAdapter);

        baseAdapter.setClickListener(((view, position) -> {
            jumpActivity(mJumpToActivity.get(position));
        }));
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