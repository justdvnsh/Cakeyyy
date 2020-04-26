package com.divyansh.cakeyyy.ui.selectedCake;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.divyansh.cakeyyy.data.CakeDatabase;
import com.divyansh.cakeyyy.data.Entities.Selected;

import java.util.List;

public class SelectedCakeViewModel extends AndroidViewModel {

    private CakeDatabase db;
    private LiveData<List<Selected>> cakeList;

    public SelectedCakeViewModel(@NonNull Application application) {
        super(application);

        db = CakeDatabase.getInstance(this.getApplication());
        cakeList = db.selectedDAO().getAllCakes();
    }

    public LiveData<List<Selected>> getAlCakes() {
        return cakeList;
    }

    public void removeFromSelectedCake(Selected selected) {
        new removeCakeAsyncTask(db).execute(selected);
    }

    private static class removeCakeAsyncTask extends AsyncTask<Selected, Void, Void> {

        private CakeDatabase db;

        public removeCakeAsyncTask(CakeDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Selected... selecteds) {
            db.selectedDAO().delete(selecteds[0]);
            return null;
        }
    }
}