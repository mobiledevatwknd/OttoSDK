package com.otto.sdk.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.otto.sdk.Logger;
import com.otto.sdk.OttoSDK;
import com.otto.sdk.R;
import com.otto.sdk.model.menu.Feature;
import com.otto.sdk.model.menu.Menu;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * TODO: document your custom view class.
 */
public class MenuView extends LinearLayout implements MenuItemClickListener, MenuFeature {
  private String mExampleString; // TODO: use a default from R.string...
  private int mExampleColor = Color.RED; // TODO: use a default from R.color...
  private float mExampleDimension = 0; // TODO: use a default from R.dimen...
  private Drawable mExampleDrawable;

  private TextPaint mTextPaint;
  private float mTextWidth;
  private float mTextHeight;

  public MenuView(Context context) {
    super(context);
    init(null, 0);
  }

  public MenuView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public MenuView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(attrs, defStyle);
  }

  private void init(AttributeSet attrs, int defStyle) {
    // Load attributes
    LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(R.layout.menu_view, this);
//    ProgressBar progressBar = view.findViewById(R.id.vLoading);
//    progressBar
//    RecyclerView rv_menu = findViewById(R.id.rv_menu);
//
//    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 4);
//    MenuAdapter adapter = new MenuAdapter(this.getContext(), Utils.getMenu(), this);
//
//    rv_menu.setLayoutManager(gridLayoutManager);
//    rv_menu.setAdapter(adapter);
    Runnable task = new Runnable() {
      @Override
      public void run() {

        OttoSDK.getInstance().getFeatures(MenuView.this);
      }
    };
    ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    worker.schedule(task, 3, TimeUnit.SECONDS);
  }

  @Override
  public void onItemClick() {
    Logger.e("halllllo");
    OttoSDK.getInstance().requestGoldIframe();
  }

  @RequiresApi(api = Build.VERSION_CODES.N)
  @Override
  public void onFeatures(Menu menu) {
    View vLoading = (View) findViewById(R.id.vLoading);
    RecyclerView recyclerView = findViewById(R.id.rv_menu);
    View tvStatus = findViewById(R.id.tvStatus);

    List<Feature> features = menu.getFeatures();
    Feature feature = features.stream().filter(new Predicate<Feature>() {
          @Override
          public boolean test(Feature feature) {
            return feature.getKey().equals(OttoSDK.getClientKey());
          }
        }).findFirst()
        .orElse(null);
//    feature = null;

//    Logger.e(feature.toString());
//    Logger.e(feature.toString());
//    Logger.e(feature.toString());
//    Logger.e(feature.toString());
    if (feature == null) {
      vLoading.setVisibility(View.GONE);
      recyclerView.setVisibility(View.GONE);
      tvStatus.setVisibility(View.VISIBLE);
      return;
    }
    tvStatus.setVisibility(View.GONE);
    vLoading.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
//    LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    View view = layoutInflater.inflate(R.layout.menu_view, this);
    ((View) findViewById(R.id.vLoading)).setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);


    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 4);
    MenuAdapter adapter = new MenuAdapter(this.getContext(), feature.getItem(), this);

    recyclerView.setLayoutManager(gridLayoutManager);
    recyclerView.setAdapter(adapter);
  }
}