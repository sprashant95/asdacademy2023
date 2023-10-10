package com.example.asdsimplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] cars = {"FIAT","JAGUAR","FERRARI","FORD","JEEP","CHEVROLET",
            "FIAT","JAGUAR","FERRARI","FORD","JEEP","CHEVROLET",
            "FIAT","JAGUAR","FERRARI","FORD","JEEP","CHEVROLET"};

    Integer[] image = {R.drawable.fiat,R.drawable.jaguar,R.drawable.ferrari,
            R.drawable.ford,R.drawable.jeep,R.drawable.chevrolet,
            R.drawable.fiat,R.drawable.jaguar,R.drawable.ferrari,
            R.drawable.ford,R.drawable.jeep,R.drawable.chevrolet,
            R.drawable.fiat,R.drawable.jaguar,R.drawable.ferrari,
            R.drawable.ford,R.drawable.jeep,R.drawable.chevrolet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        MyListAdapter myListAdapter = new MyListAdapter(this,cars,image);
        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(MainActivity.this,DetailedActivity.class);

                intent.putExtra("productname",cars[position]);
                intent.putExtra("productimage",image[position]);

                startActivity(intent);

            }
        });


    }
}