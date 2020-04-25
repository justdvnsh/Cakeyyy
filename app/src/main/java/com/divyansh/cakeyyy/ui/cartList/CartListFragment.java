package com.divyansh.cakeyyy.ui.cartList;

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

public class CartListFragment extends Fragment {

    private CartListViewModel cartListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartListViewModel =
                ViewModelProviders.of(this).get(CartListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart_list, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        cartListViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}