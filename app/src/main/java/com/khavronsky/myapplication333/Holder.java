package com.khavronsky.myapplication333;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class Holder extends RecyclerView.ViewHolder {
    TextView tv_item;
    private String text = "";

    public Holder(View view) {
        super(view);
        tv_item = (TextView) view.findViewById(R.id.tv3_item);
        tv_item.setText(text);
    }

    public void setText(String text) {
        this.text = text;
        tv_item.setText(text);
    }
}
