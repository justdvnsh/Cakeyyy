package com.divyansh.cakeyyy.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.data.Entities.Selected;

import java.util.List;

@Dao
public interface SelectedCakeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Selected selected);

    @Delete
    void delete(Selected selected);

    @Query("SELECT * FROM " + Selected.TABLE_NAME)
    LiveData<List<Selected>> getAllCakes();
}
