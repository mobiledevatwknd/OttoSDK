package com.otto.sdk;

import android.util.Log;


public class Logger {
//  public static boolean enabled = OttoSDK.getInstance().isEnableLog();

  private static boolean isEnabled() {
    return OttoSDK.getInstance().isEnableLog();
  }

  public static void d(String tag, String message) {
    if (isEnabled()) {
      Log.d("" + tag, "" + message);
    }
  }

  public static void d(String message) {
    if (isEnabled()) {
      Log.d(Constants.TAG, "" + message);
    }
  }


  public static void i(String tag, String message) {
    if (isEnabled()) {
      Log.i("" + tag, "" + message);
    }
  }

  public static void i(String message) {
    if (isEnabled()) {
      Log.i(Constants.TAG, "" + message);
    }
  }

  public static void e(String tag, String message) {
//    if (BuildConfig.FLAVOR.equalsIgnoreCase("development"))
    Log.e("" + tag, "" + message);
  }

  public static void e(String tag, Throwable throwable) {
//    if (BuildConfig.FLAVOR.equalsIgnoreCase("development"))
    Log.e("" + tag, "exeption:", throwable);
  }

  public static void e(String message) {
    if (isEnabled()) {
      Log.e(Constants.TAG, "" + message);
    }
  }
}
