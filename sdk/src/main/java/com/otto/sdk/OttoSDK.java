package com.otto.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.otto.sdk.model.iframe.ResIframe;
import com.otto.sdk.model.login.ResLogin;
import com.otto.sdk.model.menu.Menu;
import com.otto.sdk.model.token.BaseResponse;
import com.otto.sdk.parser.JacksonRequest;
import com.otto.sdk.ui.MenuFeature;

import java.util.HashMap;
import java.util.Map;


public class OttoSDK {
  private static volatile OttoSDK ottoSDK;
  private static SdkBuilder sdkBuilder;
  private static boolean sdkNotAvailable = false;
  private String token = "";
  private String clientKey = null;
  private Context context = null;

  private Application mApplication = null;
  private Activity mActivity = null;

  private static OttoListener ottoListener = null;
  private Map<String, Integer> drawables = new HashMap<String, Integer>(){
    {
      put("telepon-dan-air", R.drawable.ic_imkas_phone );
      put("listrik", R.drawable.ic_imkas_pln);
      put("voucher-game", R.drawable.ic_imkas_game);
      put("donasi", R.drawable.ic_imkas_duit);
      put("asuransi", R.drawable.ic_imkas_insurance);
      put("bpjs", R.drawable.ic_imkas_bpjs);
      put("multifinance", R.drawable.ic_imkas_multifinance);
      put("emas", R.drawable.ic_gold_bars);
    }
  };

  private OttoSDK() {
  }

  private OttoSDK(SdkBuilder sdkBuilder) {
    this.clientKey = sdkBuilder.clientKey;
    this.context = sdkBuilder.context;
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

  public static String getClientKey() {
    return ottoSDK.clientKey;
  }

  public Map<String, Integer> getDrawables() {
    return drawables;
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

  public void getFeatures(MenuFeature listener) {
    RequestQueue queue = Volley.newRequestQueue(ottoSDK.context);
    String url = "https://app.weekendinc.com/data/data.json";
    Response.Listener<Menu> onSuccess = response -> {
      Logger.e(response.toString());
      listener.onFeatures(response);
    };

    JacksonRequest.FailureListener onFail = (code, message) -> Logger.e("FAIL:" + code + ": " + message);
    JacksonRequest<Menu> jacksonRequest = new JacksonRequest<Menu>(
        Menu.class,
        Request.Method.GET,
        new HashMap<>(),
        new HashMap<>(),
        url,
        onSuccess,
        onFail);
    queue.add(jacksonRequest);
  }

  private void getSDKToken() {
    RequestQueue queue = Volley.newRequestQueue(ottoSDK.context);
    String url = Constants.HOST_URL + "/token/get";
    Response.Listener<BaseResponse> onSuccess = response -> {
      Logger.e(response.toString());
      Logger.e(response.getToken().toString());
      ottoSDK.doLogin(response.getToken().getTokenCode());
    };

    JacksonRequest.FailureListener onFail = (code, message) -> Logger.e("FAIL:" + code + ": " + message);

    HashMap<String, String> params = new HashMap<>();
    params.put("name", "admin");
    params.put("secret_key", "admin123");

    JacksonRequest<BaseResponse> jacksonRequest = new JacksonRequest<BaseResponse>(
        BaseResponse.class,
        Request.Method.POST,
        new HashMap<>(),
        params,
        url,
        onSuccess,
        onFail);
    queue.add(jacksonRequest);
  }

  private void doLogin(String token) {
    RequestQueue queue = Volley.newRequestQueue(ottoSDK.context);
    String url = Constants.HOST_URL + "/token/login";
    Response.Listener<ResLogin> onSuccess = response -> {
      Logger.e(response.toString());
      Logger.e(response.getData().toString());
      OttoSDK.this.token = response.getData().getTokenCode();
    };

    JacksonRequest.FailureListener onFail = (code, message) -> Logger.e("FAIL:" + code + ": " + message);

    HashMap<String, String> params = new HashMap<>();
    params.put("email", "billy.ardiwan@weekendinc.com");
    params.put("password", "Weekendinc123!");

    HashMap<String, String> headers = new HashMap<>();
    headers.put("wknd-token", token);

    JacksonRequest<ResLogin> jacksonRequest = new JacksonRequest<ResLogin>(
        ResLogin.class,
        Request.Method.POST,
        headers,
        params,
        url,
        onSuccess,
        onFail);
    queue.add(jacksonRequest);
  }

  public void requestGoldIframe() {
    RequestQueue queue = Volley.newRequestQueue(ottoSDK.context);
    String url = Constants.HOST_URL + "/gold/get_iframe";
    Response.Listener<ResIframe> onSuccess = response -> {
      Logger.e(response.toString());
      Logger.e(response.getData().toString());
      WebContent.openFeature(ottoSDK.context, response.getData().getIframeUrl(), "www.google.com");
    };

    JacksonRequest.FailureListener onFail = (code, message) -> Logger.e("FAIL:" + code + ": " + message);

    HashMap<String, String> headers = new HashMap<>();
    headers.put("wknd-token", token);

    JacksonRequest<ResIframe> jacksonRequest = new JacksonRequest<ResIframe>(
        ResIframe.class,
        Request.Method.POST,
        headers,
        new HashMap<>(),
        url,
        onSuccess,
        onFail);
    queue.add(jacksonRequest);
  }
}
