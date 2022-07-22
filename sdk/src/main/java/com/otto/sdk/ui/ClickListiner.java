package com.otto.sdk.ui;


//public class ClickListiner{
//
//    private ListItemClickListener mOnClickListener;
//
//    interface ListItemClickListener{
//        void onListItemClick(int position);
//    }
//
//    public void onListItemClick(ListItemClickListener mOnClickListener) {
//        this.mOnClickListener = mOnClickListener;
//    }
//}

public interface ClickListiner {
    void onClick(int position);

}

