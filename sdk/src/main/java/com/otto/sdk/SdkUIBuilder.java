package com.otto.sdk;

import android.content.Context;

public class SdkUIBuilder extends SdkBuilder {

  private SdkUIBuilder(Context context) {
    this.context = context;
  }

  private SdkUIBuilder(Context context, String clientKey) {
    this.context = context;
    this.clientKey = clientKey;
  }

  public static SdkUIBuilder init(Context context) {
    return new SdkUIBuilder(context);
  }


  public SdkUIBuilder setClientKey(String clientKey) {
    this.clientKey = clientKey;
    return this;
  }

  public SdkUIBuilder setContext(Context context) {
    this.context = context;
    return this;
  }

  public SdkUIBuilder enableLog(boolean enableLog) {
    this.enableLog = enableLog;
    return this;
  }
}
