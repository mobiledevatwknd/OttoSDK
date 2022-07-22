package com.otto.sdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otto.sdk.OttoSDK;
import com.otto.sdk.R;
import com.otto.sdk.event.MenuItemClickListener;
import com.otto.sdk.model.menu.Item;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

  private Context context;
  private List<Item> items;
  private MenuItemClickListener listener;

  public MenuAdapter(Context context, List<Item> items, MenuItemClickListener listener) {
    this.context = context;
    this.items = items;
    this.listener = listener;
  }

  @NonNull
  @Override
  public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
    return new MenuViewHolder(v);
  }


  @Override
  public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
    int index = holder.getAdapterPosition();
    Item item = items.get(position);
    String codeName = item.getCode();
    String label = item.getName();
    holder.iconName.setImageResource(OttoSDK.getInstance().getDrawables().get(codeName));
    holder.labelName.setText(label);
    holder.view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        listener.onItemClick();
      }
    });
  }


  @Override
  public int getItemCount() {
    return items.size();
  }
}
