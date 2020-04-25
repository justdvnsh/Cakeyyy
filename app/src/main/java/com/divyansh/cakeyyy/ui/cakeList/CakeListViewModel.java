package com.divyansh.cakeyyy.ui.cakeList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CakeListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CakeListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}