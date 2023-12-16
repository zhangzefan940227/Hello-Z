package com.main.app.recycler.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.main.app.R;
import com.main.app.recycler.adapter.WaterFallAdapter;

public class WaterFallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);

        RecyclerView recyclerView = findViewById(R.id.waterfall_rv);

//        // 关闭动画效果，也可以优化白屏问题，但此处不管用
//        SimpleItemAnimator sa=(SimpleItemAnimator )recyclerView.getItemAnimator();
//        if (sa != null) {
//            sa.setSupportsChangeAnimations(false);
//        }
//
        // 通过设置动画为空，解决刷新白屏问题
        recyclerView.setItemAnimator(null);


        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new WaterFallAdapter());
    }
}
