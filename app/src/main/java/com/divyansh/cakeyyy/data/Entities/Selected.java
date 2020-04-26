package com.divyansh.cakeyyy.data.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.divyansh.cakeyyy.network.POJO.Datum;

import static com.divyansh.cakeyyy.data.Entities.Selected.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Selected {

    public static final String TABLE_NAME = "selected";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private Datum data;

    public Selected(Datum data) {
        this.data = data;
    }

    public Datum getData() {
        return data;
    }

    public void setData(Datum data) {
        this.data = data;
    }
}
