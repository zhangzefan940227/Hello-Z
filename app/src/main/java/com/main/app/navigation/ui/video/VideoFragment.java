package com.main.app.navigation.ui.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.main.app.databinding.FragmentVideoBinding;

public class VideoFragment extends Fragment {
    private FragmentVideoBinding videoBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VideoViewModel videoViewModel = new ViewModelProvider(this).get(VideoViewModel.class);

        videoBinding = FragmentVideoBinding.inflate(inflater, container, false);
        View root = videoBinding.getRoot();

        final TextView textView = videoBinding.textVideo;
        videoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        videoBinding = null;
    }
}
