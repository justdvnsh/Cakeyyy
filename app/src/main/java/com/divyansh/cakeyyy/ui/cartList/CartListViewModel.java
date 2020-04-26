package com.divyansh.cakeyyy.ui.cartList;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.divyansh.cakeyyy.data.CakeDatabase;
import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.network.POJO.Cake;

import java.util.List;

public class CartListViewModel extends AndroidViewModel {

    private CakeDatabase db;
    private final LiveData<List<Cart>> cakeList;

    public CartListViewModel(@NonNull Application application) {
        super(application);

        db = CakeDatabase.getInstance(this.getApplication());
        cakeList = db.cartDAO().getAllCakes();
    }

    public LiveData<List<Cart>> getAllCakes() {
        return cakeList;
    }

    public void removeCakeFromDatabase(Cart cart) {
        new deleteAsyncTask(db).execute(cart);
    }

    private static class deleteAsyncTask extends AsyncTask<Cart, Void, Void> {

        private CakeDatabase db;

        public deleteAsyncTask(CakeDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Cart... carts) {
            db.cartDAO().delete(carts[0]);
            return null;
        }
    }
}