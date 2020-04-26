package com.divyansh.cakeyyy.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.divyansh.cakeyyy.data.DAO.CartDAO;
import com.divyansh.cakeyyy.data.DAO.SelectedCakeDAO;
import com.divyansh.cakeyyy.data.Entities.Cart;
import com.divyansh.cakeyyy.data.Entities.Selected;

@Database(entities = {
        Cart.class,
        Selected.class
}, version = 2)
public abstract class CakeDatabase extends RoomDatabase {
    private static CakeDatabase INSTANCE;

    public static CakeDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CakeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CakeDatabase.class, "cakes")
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    public abstract CartDAO cartDAO();
    public abstract SelectedCakeDAO selectedDAO();
}
