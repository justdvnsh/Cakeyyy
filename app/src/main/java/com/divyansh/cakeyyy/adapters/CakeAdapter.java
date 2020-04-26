package com.divyansh.cakeyyy.adapters;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.cakeyyy.R;
import com.divyansh.cakeyyy.network.POJO.Cake;
import com.divyansh.cakeyyy.network.POJO.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.cakeViewHolder> {

    private List<Datum> cakeList;
    private Context context;

    public CakeAdapter(Context context, List<Datum> cakeList) {
        this.context = context;
        this.cakeList = cakeList;
    }

    @NonNull
    @Override
    public CakeAdapter.cakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cakeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cake_recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CakeAdapter.cakeViewHolder holder, int position) {
        Datum cake = cakeList.get(position);
        Log.i("Picutre", cake.getWLP().get(0).getPictures());
//        Picasso.with(context).load("http://kekizadmin.com/uploads/catrgories/" + cake.getWLP().get(0).getPictures())
        holder.cakeName.setText(cake.getCakeName());
        holder.cakeWeight.setText(cake.getWLP().get(0).getWeight());
        holder.cakePrice.setText(cake.getWLP().get(0).getPrice());
    }

    @Override
    public int getItemCount() {
        return cakeList.size();
    }

    public void addCakes(List<Datum> cakeList) {
        this.cakeList = cakeList;
        notifyDataSetChanged();
    }

    public class cakeViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cake_image_holder)
        ImageView cakeImage;

        @BindView(R.id.cake_name_holder)
        TextView cakeName;

        @BindView(R.id.cake_weight_holder)
        TextView cakeWeight;

        @BindView(R.id.cake_price_holder)
        TextView cakePrice;

        @BindView(R.id.cake_add_to_cart)
        Button cakeAddToCart;

        public cakeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
