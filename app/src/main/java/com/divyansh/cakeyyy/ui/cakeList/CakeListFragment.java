package com.divyansh.cakeyyy.ui.cakeList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.divyansh.cakeyyy.R;

public class CakeListFragment extends Fragment {

    private CakeListViewModel cakeListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cakeListViewModel =
                ViewModelProviders.of(this).get(CakeListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cake_list, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        cakeListViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}