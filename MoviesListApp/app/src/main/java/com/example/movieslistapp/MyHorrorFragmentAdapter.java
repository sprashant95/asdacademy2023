package com.example.movieslistapp;

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

public class MyHorrorFragmentAdapter extends ArrayAdapter<String> {


    Activity activity;
    String[] dname;
    Integer[] dimage;

    public MyHorrorFragmentAdapter(Activity activity, String[] dname, Integer[] dimage) {
        super(activity, R.layout.mycustomitem,dname);
        this.activity = activity;
        this.dname = dname;
        this.dimage = dimage;
    }

    @Override
    public int getCount() {
        return dname.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mycustomitem,null,true);

        TextView textView = rowView.findViewById(R.id.name);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        textView.setText(dname[position]);
        imageView.setImageResource(dimage[position]);

        return rowView;

    }
}
