package com.divyansh.cakeyyy.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.divyansh.cakeyyy.network.POJO.Datum;
import com.divyansh.cakeyyy.data.Entities.Cart;

import java.util.List;

@Dao
public interface CartDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Cart cart);

    @Delete
    void delete(Cart cart);

    @Query("SELECT * FROM " + Cart.TABLE_NAME)
    LiveData<List<Cart>> getAllCakes();
}
