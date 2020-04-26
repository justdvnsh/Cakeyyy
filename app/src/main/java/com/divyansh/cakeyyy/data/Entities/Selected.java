package com.divyansh.cakeyyy.data.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.divyansh.cakeyyy.network.POJO.Datum;

import static com.divyansh.cakeyyy.data.Entities.Selected.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Selected {

    public static final String TABLE_NAME = "selected";

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String imageUrl;
    private String cakeName;
    private String cakeWeight;
    private String cakePrice;

    public Selected(String imageUrl, String cakeName, String cakeWeight, String cakePrice){
        this.imageUrl = imageUrl;
        this.cakeName = cakeName;
        this.cakeWeight = cakeWeight;
        this.cakePrice = cakePrice;
    }

    public String getCakeName() {
        return cakeName;
    }

    public String getCakePrice() {
        return cakePrice;
    }

    public String getCakeWeight() {
        return cakeWeight;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
