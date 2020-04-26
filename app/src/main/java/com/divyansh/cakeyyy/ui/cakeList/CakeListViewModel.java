package com.divyansh.cakeyyy.ui.cakeList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.divyansh.cakeyyy.di.CakeComponent;
import com.divyansh.cakeyyy.di.DaggerCakeComponent;
import com.divyansh.cakeyyy.di.modules.CakeModule;
import com.divyansh.cakeyyy.network.APIEndpoints;
import com.divyansh.cakeyyy.network.POJO.Cake;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CakeListViewModel extends AndroidViewModel {

    private APIEndpoints apiEndpoints;
    private CakeComponent cakeComponent;

    public CakeListViewModel(@NonNull Application application) {
        super(application);

        cakeComponent = DaggerCakeComponent.builder().cakeModule(new CakeModule()).build();
        apiEndpoints = cakeComponent.getAPIEndpoints();
    }

//    public void reci
}