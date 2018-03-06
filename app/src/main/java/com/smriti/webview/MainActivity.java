package com.smriti.webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
WebView webBukin;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd=new ProgressDialog(MainActivity.this);
        pd.setTitle("please wait......");
        pd.setMessage("loading");
        pd.setCancelable(false);
        webBukin=(WebView) findViewById(R.id.webBukin);
        WebSettings webSettings=webBukin.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webBukin.setWebViewClient(new WebViewClient() {

            @Override

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                setContentView(R.layout.error_layout);
            }
        });
        webBukin.setWebChromeClient(new WebChromeClient()
        );
        webBukin.loadUrl("https://bukin.in");
    }
}
