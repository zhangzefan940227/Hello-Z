package com.main.app.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.main.app.R;
import com.main.app.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding mNavigationBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigationBinding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(mNavigationBinding.getRoot());

        initView();
    }

    private void initView() {
        //第一种方法，把nav_fragment控件改为fragment
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_video, R.id.navigation_message, R.id.navigation_mine)
                .build();

        //让bottomNavigationView与NavController相关联 通过fragment id创建NavController
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        //通过操作此方法，顶部标题栏的标题会在切换fragment时同步更新，内容为navigation_items.xml的控件title
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(mNavigationBinding.mainNavigationBar, navController);
    }
}
