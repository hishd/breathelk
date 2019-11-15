package com.breathe.breathelk.MenuUI.Settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragSettingsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FragSettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Settings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
