package com.otto.sdk;

import android.app.Activity;

public interface OttoListener {
  void onSaldoUpdate(String saldo);

  void onUserProfile(String profileData);
}
