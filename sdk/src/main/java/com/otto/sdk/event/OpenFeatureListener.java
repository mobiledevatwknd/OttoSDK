package com.otto.sdk.event;

public interface OpenFeatureListener {
  void onSuccess(int status);

  void onFail(Error error);
}
