package com.otto.sdk;

import android.content.Context;

public class SdkUIBuilder extends SdkBuilder {

  private SdkUIBuilder() {
  }

  private SdkUIBuilder(OttoApplication application, String clientKey) {
    this.application = application;
    this.clientKey = clientKey;
  }

  public static SdkUIBuilder init() {
    return new SdkUIBuilder();
  }


  public SdkUIBuilder setClientKey(String clientKey) {
    this.clientKey = clientKey;
    return this;
  }

  public SdkUIBuilder setApplication(OttoApplication application) {
    this.application = application;
    return this;
  }

  public SdkUIBuilder enableLog(boolean enableLog) {
    this.enableLog = enableLog;
    return this;
  }
}
