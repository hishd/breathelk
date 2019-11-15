package com.breathe.breathelk.MenuUI.ReadArticles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.breathe.breathelk.R;

public class Frag_ReadArticles extends Fragment {

    private FragReadArticlesViewModel fragReadArticlesViewModel;
    WebView webView;

    public static Frag_ReadArticles newInstance() {
        return new Frag_ReadArticles();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragReadArticlesViewModel = ViewModelProviders.of(this).get(FragReadArticlesViewModel.class);
        View root = inflater.inflate(R.layout.frag__read_articles_fragment, container, false);
        fragReadArticlesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        webView =(WebView)root.findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webView.loadUrl("http://breathe.lk");

        return root;
    }



}
