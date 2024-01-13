package com.main.app.recycler.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.main.app.R;
import com.main.app.databinding.ActivityGridBinding;
import com.main.app.utils.BaseAdapter;
import com.main.app.utils.BaseViewHolder;

public class GridActivity extends AppCompatActivity {
    private ActivityGridBinding gridBinding;
    GridLayoutManager verticalManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
    GridLayoutManager horizontalManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
    BaseAdapter<String> gridAdapter = new BaseAdapter<>(null, new BaseAdapter.IBindDataListener<String>() {
        @Override
        public void onBindViewHolder(String content, BaseViewHolder viewHolder, int type, int position) {
            viewHolder.setText(R.id.grid_rv, content);
        }

        @Override
        public int getLayoutId(int type) {
            return R.layout.item_list_grid;
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
        gridBinding = DataBindingUtil.setContentView(this, R.layout.activity_grid);
        initView();
    }

    private void initView() {
        gridBinding.gridRv.setHasFixedSize(true);
        gridBinding.gridRv.setLayoutManager(horizontalManager);
        gridBinding.sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                gridBinding.gridRv.setLayoutManager(verticalManager);
            } else {
                gridBinding.gridRv.setLayoutManager(horizontalManager);
            }
        });
        gridBinding.gridRv.setAdapter(gridAdapter);
    }
}
