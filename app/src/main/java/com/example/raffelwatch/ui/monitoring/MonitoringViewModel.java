package com.example.raffelwatch.ui.monitoring;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MonitoringViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MonitoringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Monitoring");
    }

    public LiveData<String> getText() {
        return mText;
    }
}