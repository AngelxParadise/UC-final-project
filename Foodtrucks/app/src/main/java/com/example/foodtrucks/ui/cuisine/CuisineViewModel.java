package com.example.foodtrucks.ui.cuisine;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CuisineViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CuisineViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}