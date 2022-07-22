package com.otto.sdk.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.otto.sdk.R;

public class MenuViewHolder extends RecyclerView.ViewHolder {
  ImageView iconName;
  TextView labelName;
  View view;

  MenuViewHolder(View itemView) {
    super(itemView);
    iconName = (ImageView) itemView.findViewById(R.id.iconName);
    labelName = (TextView) itemView.findViewById(R.id.labelName);
    view = itemView;
  }
}
