package com.divyansh.cakeyyy.network;

import com.divyansh.cakeyyy.network.POJO.Cake;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIEndpoints {

    public static final String ACTION_STRING = "get_cakes";
    public static final int CATEGORY = 27;

    @GET("/kekiz_api/actions.php")
    Call<Cake> getCakes(@Query("action") String action, @Query("category") int cat);
}
