package com.breathe.breathelk.MenuUI.Default;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragDefaultViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FragDefaultViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Default fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
