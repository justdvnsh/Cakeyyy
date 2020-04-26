package com.divyansh.cakeyyy.ui.cakeList;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.divyansh.cakeyyy.data.CakeDatabase;
import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.network.POJO.Datum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CakeListViewModel extends AndroidViewModel {

    private CakeDatabase db;

    public CakeListViewModel(@NonNull Application application) {
        super(application);

        db = CakeDatabase.getInstance(this.getApplication());
    }

    public void insertCakeToCart(Cart cart){
        new insertCakeToCartAsyncTask(db).execute(cart);
    }

    private static class insertCakeToCartAsyncTask extends AsyncTask<Cart, Void, Void> {

        private CakeDatabase db;

        public insertCakeToCartAsyncTask(CakeDatabase db){
            this.db = db;
        }

        @Override
        protected Void doInBackground(Cart... carts) {
            db.cartDAO().save(carts[0]);
            return null;
        }
    }
}