package com.otto.sdk;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


public class OttoSDK {
  private static volatile OttoSDK ottoSDK;
  private static SdkBuilder sdkBuilder;
  private static boolean sdkNotAvailable = false;
  private String clientKey = null;
  private OttoApplication application = null;

  private Application mApplication = null;
  private Activity mActivity = null;

  public Activity getmActivity() {
    return mActivity;
  }

  public void setmActivity(Activity mActivity) {
    this.mActivity = mActivity;
  }

  public Application getmApplication() {
    return mApplication;
  }

  public void setmApplication(Application mApplication) {
    this.mApplication = mApplication;
  }

  private static OttoListener ottoListener = null;

  private OttoSDK() {
  }

  private OttoSDK(SdkBuilder sdkBuilder) {
    this.clientKey = sdkBuilder.clientKey;
    this.application = sdkBuilder.application;
  }

  protected static OttoSDK delegateInstance(SdkBuilder newSdkBuilder) {
    if (newSdkBuilder != null) {
      ottoSDK = new OttoSDK(newSdkBuilder);
      sdkBuilder = newSdkBuilder;
    } else {
      Logger.e("sdk is not initialized");
    }
    return ottoSDK;
  }

  public synchronized static OttoSDK getInstance() {
    if (ottoSDK == null) {
      synchronized (OttoSDK.class) {
        if (ottoSDK == null) {
          if (sdkBuilder == null) {
            ottoSDK = new OttoSDK();
            sdkNotAvailable = true;
          } else {
            ottoSDK = new OttoSDK(sdkBuilder);
            sdkNotAvailable = false;
          }
        }
      }
    } else {
      sdkNotAvailable = false;
    }
    return ottoSDK;
  }

  public static void getSaldo(OttoListener listener) {
//    ottoListener = listener;
//    WritableMap props = new WritableNativeMap();
//    props.putString("x", "xvalue");
//    props.putInt("y", 123);
//    ottoSDK.sendToJS(ottoSDK.application.getReactNativeHost().getReactInstanceManager().getCurrentReactContext(), "getSaldo", props);
  }

  public static void onSaldoUpdate(String totalSaldo) {
    ottoListener.onSaldoUpdate(totalSaldo);
  }

  public static void getUserProfile(String phoneNumber, OttoListener listener) {
//    WritableMap props = new WritableNativeMap();
//    props.putString("phone_number", phoneNumber);
//    ottoListener = listener;
//    ReactContext reactContext = ottoSDK.application.getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
//    ottoSDK.sendToJS(reactContext, "getUserProfile", props);
  }

  public static void onUserProfile(String profileData) {
    ottoListener.onUserProfile(profileData);
  }

//
}
