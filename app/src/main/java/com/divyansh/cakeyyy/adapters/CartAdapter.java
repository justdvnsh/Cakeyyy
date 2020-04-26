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
import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.network.POJO.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.cartViewHolder> {

    private List<Cart> cakeList;
    private Context context;
    private mOnAddToSelectedListener addToSelectedListener;

    public interface mOnAddToSelectedListener {
        void addToSelected();
    }

    public CartAdapter(Context context, List<Cart> cakeList) {
        this.context = context;
        this.cakeList = cakeList;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cartViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        Cart cake = cakeList.get(position);
        Picasso.with(context).load(cake.getImageUrl()).into(holder.cakeImage);
        holder.cakeName.setText(cake.getCakeName());
        holder.cakeWeight.setText(cake.getCakeWeight());
        holder.cakePrice.setText(cake.getCakePrice());
        holder.cakeAddToSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Added to seleted", Toast.LENGTH_SHORT).show();
            }
        });

        holder.cakeRemoveFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Removed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cakeList.size();
    }

    public void addCakes(List<Cart> cakeList) {
        this.cakeList = cakeList;
        notifyDataSetChanged();
    }

    public class cartViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cake_image_holder)
        ImageView cakeImage;

        @BindView(R.id.cake_name_holder)
        TextView cakeName;

        @BindView(R.id.cake_weight_holder)
        TextView cakeWeight;

        @BindView(R.id.cake_price_holder)
        TextView cakePrice;

        @BindView(R.id.cake_add_to_selected)
        Button cakeAddToSelected;

        @BindView(R.id.cake_remove_from_cart)
        Button cakeRemoveFromCart;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
