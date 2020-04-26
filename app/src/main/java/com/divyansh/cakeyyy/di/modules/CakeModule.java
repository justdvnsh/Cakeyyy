package com.divyansh.cakeyyy.di.modules;

import com.divyansh.cakeyyy.network.APIEndpoints;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CakeModule {

    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl("http://kekizadmin.com/kekiz_api/")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }


    // and here we got the apiEndpoints
    @Provides
    public APIEndpoints apiEndpoints(Retrofit retrofit) {
        return retrofit.create(APIEndpoints.class);
    }
}
