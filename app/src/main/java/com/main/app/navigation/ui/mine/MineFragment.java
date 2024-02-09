package com.main.app.navigation.ui.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.main.app.databinding.FragmentMineBinding;

public class MineFragment extends Fragment {

    private FragmentMineBinding mineBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MineViewModel mineViewModel = new ViewModelProvider(this).get(MineViewModel.class);
        mineBinding = FragmentMineBinding.inflate(inflater, container, false);
        View view = mineBinding.getRoot();

        final TextView textView = mineBinding.textMine;
        mineViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mineBinding = null;
    }
}
