package com.otto.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebContent extends AppCompatActivity {
  public static void openFeature(Context context, String value, String value2) {
    Intent webContent = new Intent(context, WebContent.class);
    webContent.putExtra("url", value);
    webContent.putExtra("closeurl", value2);
    context.startActivity(webContent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.webcontent);
//        TextView textView = (TextView) findViewById(R.id.textView);
    WebView myWebView = (WebView) findViewById(R.id.webview);
    Intent intent = getIntent();
    String openUrl = intent.getStringExtra("url");
    String closeUrl = intent.getStringExtra("closeurl");
//        textView.setText(url);
    myWebView.setInitialScale(1);
    myWebView.getSettings().setLoadWithOverviewMode(true);
    myWebView.getSettings().setUseWideViewPort(true);
    myWebView.getSettings().setJavaScriptEnabled(true);
//        myWebView.setWebViewClient(new WebViewClient());
    myWebView.loadUrl(openUrl);
    myWebView.setWebViewClient(new WebViewClient() {
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
//           String url = myWebView.getUrl();
        if (url.contains(closeUrl)) {
          finish();
        }
        return false;
      }
    });


  }

  @Override
  public void onBackPressed() {
    WebView myWebView = (WebView) findViewById(R.id.webview);
    if (myWebView.canGoBack())
      myWebView.goBack();
    else
      super.onBackPressed();
  }

  public void backButton(View v) {
    finish();

  }
}
