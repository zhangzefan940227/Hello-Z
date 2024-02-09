package com.main.app.navigation.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.main.app.databinding.FragmentMessageBinding;

public class MessageFragment extends Fragment {

    private FragmentMessageBinding messageBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MessageViewModel messageViewModel = new ViewModelProvider(this).get(MessageViewModel.class);

        messageBinding = FragmentMessageBinding.inflate(inflater, container, false);
        View view = messageBinding.getRoot();
        final TextView textView = messageBinding.textMessage;
        messageViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        messageBinding = null;
    }
}
