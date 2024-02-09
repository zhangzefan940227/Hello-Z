package com.main.app.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityRecyclerBinding;
import com.main.app.menu.model.MenuModel;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;
import com.main.app.utils.XmlPullParserUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class RecyclerActivity extends AppCompatActivity {

    private ActivityRecyclerBinding activityRecyclerBinding;

    private List<MenuModel> mBaseMenuModelList;
    private List<MenuModel> mAdvanceMenuModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
         activityRecyclerBinding = null;
         mBaseMenuModelList = null;
         mAdvanceMenuModelList = null;
    }

    private void init() {
        basicInitData();
        basicInitView();

        advancedInitData();
        advancedInitView();
    }

    private void basicInitData() {
        try {
            InputStream menuStream = Objects.requireNonNull(getClass().getClassLoader()).
                    getResourceAsStream("assets/recyclerview_basic_menu_list.xml");
            mBaseMenuModelList = XmlPullParserUtils.getMenuList(menuStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void basicInitView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        BaseAdapter<MenuModel> baseAdapter = new BaseAdapter<>(mBaseMenuModelList, new BaseAdapter.IBindDataListener<MenuModel>() {
            @Override
            public void onBindViewHolder(MenuModel model, BaseViewHolder viewHolder, int type, int position) {
                viewHolder.setText(R.id.item_recycler_tv, model.getTitle());
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
            startActivity(new Intent(this, mBaseMenuModelList.get(position).getJumpToWhere()));
        });
    }

    private void advancedInitData() {
        try {
            InputStream menuStream = Objects.requireNonNull(getClass().getClassLoader()).
                    getResourceAsStream("assets/recyclerview_advanced_menu_list.xml");
            mAdvanceMenuModelList = XmlPullParserUtils.getMenuList(menuStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void advancedInitView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        BaseAdapter<MenuModel> baseAdapter = new BaseAdapter<>(mAdvanceMenuModelList, new BaseAdapter.IBindDataListener<MenuModel>() {
            @Override
            public void onBindViewHolder(MenuModel model, BaseViewHolder viewHolder, int type, int position) {
                viewHolder.setText(R.id.item_recycler_tv, model.getTitle());
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
            startActivity(new Intent(this, mAdvanceMenuModelList.get(position).getJumpToWhere()));
        });
    }
}