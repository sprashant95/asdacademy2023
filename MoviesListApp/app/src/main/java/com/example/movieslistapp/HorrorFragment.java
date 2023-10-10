package com.example.movieslistapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class HorrorFragment extends Fragment {

    ListView listView;

    String[] name = {"Adipurush","Bambai, An Untold Story","1920 Evil Returns",
            "Jailer","Jaane Jaan","Rocky Ki Rani", "Guns and Gulaabs"};

    Integer[] posters = {R.drawable.adipurush,R.drawable.bambai,R.drawable.devil1920,R.drawable.jailer,
    R.drawable.janejaan,R.drawable.rockyandrani, R.drawable.gunsandgulabs};

    public HorrorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horror, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        listView = view.findViewById(R.id.list);

        MyHorrorFragmentAdapter myHorrorFragmentAdapter = new MyHorrorFragmentAdapter(getActivity(),name,posters);
        listView.setAdapter(myHorrorFragmentAdapter);
    }
}