package com.main.app.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.main.app.R;
import com.main.app.recycler.base.GridActivity;
import com.main.app.recycler.base.HorizontalActivity;
import com.main.app.recycler.base.VerticalActivity;
import com.main.app.recycler.base.WaterFallActivity;

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mVertical, mHorizontal, mGrid, mWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.vertical_bt) {
            Intent i = new Intent(this, VerticalActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.horizontal_bt) {
            Intent i = new Intent(this, HorizontalActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.grid_bt) {
            Intent i = new Intent(this, GridActivity.class);
            startActivity(i);
        } else if (v.getId() == R.id.waterfall_bt) {
            Intent i = new Intent(this, WaterFallActivity.class);
            startActivity(i);
        }
    }

    private void initView() {
        mVertical = findViewById(R.id.vertical_bt);
        mVertical.setOnClickListener(this);
        mHorizontal = findViewById(R.id.horizontal_bt);
        mHorizontal.setOnClickListener(this);
        mGrid = findViewById(R.id.grid_bt);
        mGrid.setOnClickListener(this);
        mWaterFall = findViewById(R.id.waterfall_bt);
        mWaterFall.setOnClickListener(this);
    }
}