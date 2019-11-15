package com.breathe.breathelk.MenuUI.ReadArticles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragReadArticlesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FragReadArticlesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Read Article fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
