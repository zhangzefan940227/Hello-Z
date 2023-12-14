package com.main.app.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.main.app.R;

public class AnimationActivity extends AppCompatActivity {
    private ImageView mImg;

    private Button mAlpha, mRota, mTransX, mTransY, mRotaX, mRotaY, mScaleX, mScaleY;
    private ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
    }

    private void initView() {
        mImg = findViewById(R.id.pic);
        mAlpha = findViewById(R.id.anim_alpha);
        mRota = findViewById(R.id.anim_rotation);
        mTransX = findViewById(R.id.anim_transX);
        mTransY = findViewById(R.id.anim_transY);
        mRotaX = findViewById(R.id.anim_rotaX);
        mRotaY = findViewById(R.id.anim_rotaY);
        mScaleX = findViewById(R.id.anim_scaleX);
        mScaleY = findViewById(R.id.anim_scaleY);
        setClickListener();
    }

    private void setClickListener() {
        mAlpha.setOnClickListener(v -> {
            setAnimator("alpha", 2000, 0, 0, 1f, 0f, 1f);
        });
        mRota.setOnClickListener(v -> {
            setAnimator("rotation", 2000, 0, 0, 0f, 360f);
        });
        mTransX.setOnClickListener(v -> {
            setAnimator("translationX", 4000, 0, 0, 0f, 200f, -200f, 0f);
        });
        mTransY.setOnClickListener(v -> {
            setAnimator("translationY", 2000, 0, 0, 0f, 200f, 0f);
        });
        mRotaX.setOnClickListener(v -> {
            setAnimator("rotationX", 2000, 0, 0, 0f, 360f);
        });
        mRotaY.setOnClickListener(v -> {
            setAnimator("rotationY", 2000, 0, ValueAnimator.REVERSE, 0f, 360f);
        });
        mScaleX.setOnClickListener(v -> {
            setAnimator("scaleX", 2000, 0, ValueAnimator.REVERSE, 1f, 0.5f, 1f);
        });
        mScaleY.setOnClickListener(v -> {
            setAnimator("scaleY", 2000, 0, ValueAnimator.REVERSE, 1f, 0.5f, 1f);
        });
    }

    private void setAnimator(String anim, int duration, int repeatCount, int repeatMode, float... values) {
        mAnimator = ObjectAnimator.ofFloat(mImg, anim, values);
        mAnimator.setDuration(duration);
        mAnimator.setRepeatCount(repeatCount);
        mAnimator.setRepeatMode(repeatMode);
        mAnimator.start();
    }
}