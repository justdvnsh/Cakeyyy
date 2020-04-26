package com.divyansh.cakeyyy.ui.cakeList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.cakeyyy.R;
import com.divyansh.cakeyyy.adapters.CakeAdapter;
import com.divyansh.cakeyyy.di.CakeComponent;
import com.divyansh.cakeyyy.di.DaggerCakeComponent;
import com.divyansh.cakeyyy.di.modules.CakeModule;
import com.divyansh.cakeyyy.network.APIEndpoints;
import com.divyansh.cakeyyy.network.POJO.Cake;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CakeListFragment extends Fragment {

    private CakeListViewModel cakeListViewModel;
    private APIEndpoints apiEndpoints;
    private CakeComponent cakeComponent;
    private CakeAdapter adapter;

    @BindView(R.id.cake_list_recycler_view)
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cakeListViewModel =
                ViewModelProviders.of(this).get(CakeListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cake_list, container, false);

        ButterKnife.bind(this, root);

        cakeComponent = DaggerCakeComponent.builder().cakeModule(new CakeModule()).build();
        apiEndpoints = cakeComponent.getAPIEndpoints();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        fetchCakes();

        return root;
    }

    private void fetchCakes() {
        Call<Cake> call = apiEndpoints.getCakes(APIEndpoints.ACTION_STRING, APIEndpoints.CATEGORY);
        Log.i("Header", call.request().toString());
        call.enqueue(new Callback<Cake>() {
            @Override
            public void onResponse(Call<Cake> call, Response<Cake> response) {
                if (response.isSuccessful()) {
                    adapter = new CakeAdapter(getContext(), response.body().getData());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.i("respinse", response.message());
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cake> call, Throwable t) {
                Log.i("error", t.getMessage());
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


}