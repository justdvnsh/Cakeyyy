package com.divyansh.cakeyyy.ui.selectedCake;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.cakeyyy.R;
import com.divyansh.cakeyyy.adapters.SelectedCakeAdapter;
import com.divyansh.cakeyyy.data.Entities.Selected;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedCakeFragment extends Fragment implements SelectedCakeAdapter.mOnRemoveSelectedCakeListener{

    private SelectedCakeViewModel selectedCakeViewModel;
    private SelectedCakeAdapter adapter;

    @BindView(R.id.selected_cake_recycler_view)
    RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        selectedCakeViewModel =
                ViewModelProviders.of(this).get(SelectedCakeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_selected_cake, container, false);

        ButterKnife.bind(this, root);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new SelectedCakeAdapter(getContext(), SelectedCakeFragment.this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
        selectedCakeViewModel.getAlCakes().observe(SelectedCakeFragment.this, new Observer<List<Selected>>() {
            @Override
            public void onChanged(List<Selected> selecteds) {
                adapter.addCakes(selecteds);
            }
        });

        return root;
    }

    @Override
    public void removeCakeFromSelectedCakes(Selected selected) {
        selectedCakeViewModel.removeFromSelectedCake(selected);
    }
}