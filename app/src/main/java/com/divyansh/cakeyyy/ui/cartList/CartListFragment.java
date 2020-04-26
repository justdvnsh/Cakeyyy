package com.divyansh.cakeyyy.ui.cartList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.cakeyyy.R;
import com.divyansh.cakeyyy.adapters.CartAdapter;
import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.data.Entities.Selected;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartListFragment extends Fragment implements CartAdapter.mOnAddToSelectedListener, CartAdapter.mOnRemoveCakeListener{

    private CartListViewModel cartListViewModel;
    private CartAdapter adapter;

    @BindView(R.id.cart_list_recycler_view)
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartListViewModel =
                ViewModelProviders.of(this).get(CartListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart_list, container, false);

        ButterKnife.bind(this, root);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new CartAdapter(getContext(), CartListFragment.this, CartListFragment.this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
        cartListViewModel.getAllCakes().observe(CartListFragment.this, new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                adapter.addCakes(carts);
            }
        });

        return root;
    }

    @Override
    public void addToSelected(Selected selected) {
        cartListViewModel.addToSelected(selected);
    }

    @Override
    public void removeCake(Cart cart) {
        cartListViewModel.removeCakeFromDatabase(cart);
    }
}