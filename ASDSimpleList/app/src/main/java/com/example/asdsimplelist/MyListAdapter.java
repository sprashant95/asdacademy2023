package com.example.asdsimplelist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String> {

    Activity activity;
    String[] dcars;
    Integer[] dimage;

    public MyListAdapter(@NonNull Activity activity, String[] dcars, Integer[] dimage) {
        super(activity, R.layout.mylistitem,dcars);
        this.activity = activity;
        this.dcars = dcars;
        this.dimage = dimage;
    }

    @Override
    public int getCount() {
        return dimage.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylistitem,null,true);

        TextView textView = rowView.findViewById(R.id.text);
        ImageView imageView = rowView.findViewById(R.id.image);

        textView.setText(dcars[position]);
        imageView.setImageResource(dimage[position]);

        return rowView;

    }
}
