package com.divyansh.cakeyyy.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.cakeyyy.R;
import com.divyansh.cakeyyy.data.DAO.SelectedCakeDAO;
import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.data.Entities.Selected;
import com.divyansh.cakeyyy.network.POJO.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedCakeAdapter extends RecyclerView.Adapter<SelectedCakeAdapter.selectedCakeViewHolder> {

    private List<Selected> cakeList;
    private Context context;
    private mOnRemoveSelectedCakeListener removeCakeListener;

    public interface mOnRemoveSelectedCakeListener {
        void removeCakeFromSelectedCakes(Selected selected);
    }

    public SelectedCakeAdapter(Context context, mOnRemoveSelectedCakeListener removeCakeListener, List<Selected> cakeList) {
        this.cakeList = cakeList;
        this.context = context;
        this.removeCakeListener = removeCakeListener;
    }

    @NonNull
    @Override
    public selectedCakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new selectedCakeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.selected_cake_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull selectedCakeViewHolder holder, int position) {
        Selected cake = cakeList.get(position);
        Picasso.with(context).load(cake.getImageUrl()).into(holder.cakeImage);
        holder.cakeName.setText(cake.getCakeName());
        holder.cakeWeight.setText(cake.getCakeWeight());
        holder.cakePrice.setText(cake.getCakePrice());
        holder.selectedCakeRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCakeListener.removeCakeFromSelectedCakes(cake);
                Toast.makeText(context, "Removed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cakeList.size();
    }

    public void addCakes(List<Selected> cakeList) {
        this.cakeList = cakeList;
        notifyDataSetChanged();
    }

    public class selectedCakeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cake_image_holder)
        ImageView cakeImage;

        @BindView(R.id.cake_name_holder)
        TextView cakeName;

        @BindView(R.id.cake_weight_holder)
        TextView cakeWeight;

        @BindView(R.id.cake_price_holder)
        TextView cakePrice;

        @BindView(R.id.selected_cake_remove)
        Button selectedCakeRemove;

        public selectedCakeViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
