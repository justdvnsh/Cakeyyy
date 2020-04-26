package com.divyansh.cakeyyy.ui.cartList;

import android.app.Application;

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
}