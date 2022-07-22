package com.otto.app;

import com.otto.sdk.SdkUIBuilder;

public class Application extends android.app.Application {
  @Override
  public void onCreate() {
    super.onCreate();
    SdkUIBuilder.init(this)
        .setClientKey("V46eGCQA7YiZDCFT2ie89JZ2pwhNax")
        .enableLog(BuildConfig.DEBUG)
        .buildSDK();
  }
}
