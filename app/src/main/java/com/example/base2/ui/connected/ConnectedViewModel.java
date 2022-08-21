package com.example.base2.ui.connected;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConnectedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConnectedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Connected fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}