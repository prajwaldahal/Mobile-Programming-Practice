package com.example.widgetimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview_one);
        button=findViewById(R.id.button_one);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webView.setWebViewClient(new WebViewClient()
                {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url)
                    {
                        return false;
                    }
                });
               // webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://docs.google.com/document/d/1kT-Z59f_65Z7gdmo5iiqDl9hfXAkvWgRkLrXJURPedg/edit?usp=sharing");
            }
        });

    }
}