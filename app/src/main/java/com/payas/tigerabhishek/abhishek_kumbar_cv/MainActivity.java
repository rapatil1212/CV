package com.payas.tigerabhishek.abhishek_kumbar_cv;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    WebView mywebView;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Abhishek");
        mywebView =findViewById(R.id.webview);
        mDialog=new ProgressDialog(this);
        mDialog.setTitle("Please wait while loading page");
        mDialog.show();
        //mProgress.setVisibility(View.VISIBLE);
        mywebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int progress) {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                setTitle("Loading...");
                mDialog.setMessage("Loading: "+progress);
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if(progress == 100)
                    setTitle(R.string.app_name);
                mDialog.dismiss();
            }

        });
        WebSettings webSettings= mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("http://www.abhishekkumbar.ezyro.com/?i=2/");
        mywebView.setWebViewClient(new WebViewClient());


    }
}
