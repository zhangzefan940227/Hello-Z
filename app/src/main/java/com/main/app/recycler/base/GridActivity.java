package com.main.app.recycler.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.main.app.R;
import com.main.app.recycler.adapter.GridAdapter;

public class GridActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        SwitchCompat switchCompat = findViewById(R.id.sw);
        RecyclerView recyclerView = findViewById(R.id.grid_rv);

        GridLayoutManager verticalManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        GridLayoutManager horizontalManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(horizontalManager);
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recyclerView.setLayoutManager(verticalManager);
            } else {
                recyclerView.setLayoutManager(horizontalManager);
            }
        });
        recyclerView.setAdapter(new GridAdapter());
    }
}
