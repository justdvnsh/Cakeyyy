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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.cakeyyy.R;
import com.divyansh.cakeyyy.adapters.SelectedCakeAdapter;
import com.divyansh.cakeyyy.data.Entities.Selected;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_DRAG;
import static androidx.recyclerview.widget.ItemTouchHelper.DOWN;
import static androidx.recyclerview.widget.ItemTouchHelper.UP;

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


        ItemTouchHelper.Callback itemTouchCallback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, UP | DOWN);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                Collections.swap(adapter.getCakes(),viewHolder.getAdapterPosition(), target.getAdapterPosition());
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // do nothign
            }

            @Override
            public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);

                if (actionState == ACTION_STATE_DRAG) {
                    viewHolder.itemView.setAlpha(0.5f);
                }
            }

            @Override
            public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);

                viewHolder.itemView.setAlpha(1.0f);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return root;
    }

    @Override
    public void removeCakeFromSelectedCakes(Selected selected) {
        selectedCakeViewModel.removeFromSelectedCake(selected);
    }
}