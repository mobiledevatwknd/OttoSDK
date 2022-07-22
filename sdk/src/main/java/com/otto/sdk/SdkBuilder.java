package com.otto.sdk;

import android.content.Context;

public abstract class SdkBuilder {
  public static final String UI_FLOW = "ui";
  public static final String CORE_FLOW = "core";

  protected String clientKey = null;
  protected OttoApplication application = null;
  protected Context context = null;
  protected boolean enableLog = false;

  public OttoSDK buildSDK() {
    if (isValidData()) {
      return OttoSDK.delegateInstance(this);
    } else {
      Logger.e("invalid sdk properties");
    }
    return null;
  }

  public boolean isValidData() {
    if (clientKey == null || application == null) {
      String message = "Client key and context cannot be null or empty. Please set the client key and context";
      RuntimeException runtimeException = new RuntimeException(message);
      Logger.e(message, runtimeException);
    }

    // TODO: another validation
    return true;
  }
}
