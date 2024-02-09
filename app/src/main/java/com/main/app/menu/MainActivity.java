package com.main.app.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.main.app.R;
import com.main.app.databinding.ActivityMainBinding;
import com.main.app.menu.model.MenuModel;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;
import com.main.app.utils.LogUtils;
import com.main.app.utils.XmlPullParserUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mainBinding;
    private LinearLayoutManager mLayoutManager;
    private BaseAdapter<MenuModel> baseAdapter;
    private List<MenuModel> mMainMenuModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initData();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
         mainBinding = null;
         mLayoutManager = null;
         baseAdapter = null;
         mMainMenuModelList = null;
        LogUtils.i(TAG, "onDestroy");

    }

    public void initView() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainBinding.mainRv.setLayoutManager(mLayoutManager);

        baseAdapter = new BaseAdapter<>(mMainMenuModelList, new BaseAdapter.IBindDataListener<MenuModel>() {
            @Override
            public void onBindViewHolder(MenuModel model, BaseViewHolder viewHolder, int type, int position) {
                viewHolder.setText(R.id.item_main_tv, model.getTitle());
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
            startActivity(new Intent(this, mMainMenuModelList.get(position).getJumpToWhere()));
        }));
    }

    public void initData() {
        try {
            InputStream menuStream = Objects.requireNonNull(getClass().getClassLoader()).getResourceAsStream("assets/main_menu_list.xml");
            mMainMenuModelList = XmlPullParserUtils.getMenuList(menuStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}