package com.example.asdsimplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailedActivity extends AppCompatActivity {

    CircleImageView dimage;
    TextView dtext,dprice;

    String[] price = {"2.58 Lakhs","1.98 lakh", "2.34 Lakhs","1.2 Lakhs", "5.4 Lakhs", "7.8 Lakhs",
            "2.58 Lakhs","1.98 lakh", "2.34 Lakhs","1.2 Lakhs", "5.4 Lakhs", "7.8 Lakhs",
            "2.58 Lakhs","1.98 lakh", "2.34 Lakhs","1.2 Lakhs", "5.4 Lakhs", "7.8 Lakhs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        dimage = findViewById(R.id.dimage);
        dtext = findViewById(R.id.dtext);

        Intent intent = getIntent();
        String name = intent.getStringExtra("productname");
        Integer image = intent.getIntExtra("productimage",R.drawable.chevrolet);

        dtext.setText(name);
        dimage.setImageResource(image);


    }
}