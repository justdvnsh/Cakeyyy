package com.divyansh.cakeyyy.ui.selectedCake;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelectedCakeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SelectedCakeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}