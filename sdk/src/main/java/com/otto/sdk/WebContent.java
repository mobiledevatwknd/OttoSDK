package com.otto.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.List;

public class WebContent extends AppCompatActivity {
  public static void openFeature(Context context, String value, String value2, String token) {
    Intent webContent = new Intent(context, WebContent.class);
    webContent.putExtra("url", value);
    webContent.putExtra("closeurl", value2);
    webContent.putExtra("token", token);
    webContent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
    String token = intent.getStringExtra("token");

    myWebView.setInitialScale(1);
    myWebView.getSettings().setLoadWithOverviewMode(true);
    myWebView.getSettings().setUseWideViewPort(true);
    myWebView.getSettings().setJavaScriptEnabled(true);

    CookieManager cookieManager = CookieManager.getInstance();
    cookieManager.setAcceptCookie(true);

//    String cookienih = cookieManager.getCookie(openUrl);
//    Log.e("COOOOOKIE", cookieManager.getCookie(openUrl));
//    Log.e("TOKENEE", token);
    List<HttpCookie> cookies = HttpCookie.parse(cookieManager.getCookie(openUrl));
    ;

//    Log.e("COOOKIE", cookies.toString());
    String cookieToken = cookies.toString();
    cookieToken = !cookieToken.equals("") ? cookieToken.split("=")[1] : "";
//    cookieManager.setCookie(openUrl, token, new ValueCallback<Boolean>() {
//      @Override
//      public void onReceiveValue(Boolean value) {
//        Log.e("webview ====> receive value", value ? "true" : "false");
//      }
//    });
//    Log.e("COOOOOKIE", cookieManager.getCookie(openUrl));

//    cookieManager.flush();
//    Log.e("COOOOOKIE", cookieManager.getCookie(openUrl));
//    Log.e("COOOOOKIE", openUrl + "/queryToken=" + cookieToken);

//    myWebView.loadUrl(openUrl + "?queryToken=" + cookieToken); ////
    myWebView.loadUrl(openUrl + "?queryToken=" + token); ////
    myWebView.setWebViewClient(new WebViewClient() {
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
//           String url = myWebView.getUrl();
//        if (url.contains(closeUrl)) {
//          finish();
//        }
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
