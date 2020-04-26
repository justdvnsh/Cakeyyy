package com.divyansh.cakeyyy.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.divyansh.cakeyyy.data.DAO.CartDAO;
import com.divyansh.cakeyyy.data.Entities.Cart;

@Database(entities = {
        Cart.class
}, version = 1)
public abstract class CakeDatabase extends RoomDatabase {
    private static CakeDatabase INSTANCE;

    public static CakeDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CakeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CakeDatabase.class, "cakes")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    public abstract CartDAO cartDAO();
}
