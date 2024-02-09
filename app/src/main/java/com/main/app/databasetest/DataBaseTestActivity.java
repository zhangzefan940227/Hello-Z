package com.main.app.databasetest;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.main.app.databinding.ActivityDatabaseTestBinding;

public class DataBaseTestActivity extends AppCompatActivity {

    private ActivityDatabaseTestBinding databaseTestBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseTestBinding = ActivityDatabaseTestBinding.inflate(getLayoutInflater());
        setContentView(databaseTestBinding.getRoot());
        initView();
    }

    private void initView() {
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        databaseTestBinding.readData.setOnClickListener(v -> {
            myDatabaseHelper.getWritableDatabase();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseTestBinding = null;
    }
}
