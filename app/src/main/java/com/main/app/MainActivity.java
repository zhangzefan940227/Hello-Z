package com.main.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.main.app.animation.AnimationActivity;
import com.main.app.recycler.RecyclerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button anim_btn = findViewById(R.id.anim_btn);
        anim_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, AnimationActivity.class);
            startActivity(intent);
        });

        Button recycle_btn = findViewById(R.id.recycle_btn);
        recycle_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, RecyclerActivity.class);
            startActivity(intent);
        });
    }
}