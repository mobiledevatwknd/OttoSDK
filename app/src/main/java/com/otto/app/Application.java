package com.otto.app;

import com.otto.sdk.SdkUIBuilder;

public class Application extends android.app.Application {
  @Override
  public void onCreate() {
    super.onCreate();
    SdkUIBuilder.init(this)
//        .setClientKey("V46eGCQA7YiZDCFT2ie89JZ2pwhNax")
        .setClientKey("QzzEp5g29fFymxeMX27vc2W9mZ2Qab")
//        .setClientKey("faupAKQvQ7K4tAbf2T68FXu3Sg4aGc")
        .enableLog(BuildConfig.DEBUG)
        .buildSDK();
  }
}
