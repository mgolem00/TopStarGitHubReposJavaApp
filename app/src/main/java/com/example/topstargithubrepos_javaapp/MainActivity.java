package com.example.topstargithubrepos_javaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Items demo1 = new Items("https://github.com/mgolem00.png", "TestRepo1", "mgolem00", 100);
        Items demo2 = new Items("https://github.com/jzelic00.png", "TestRepo2", "jzelic00", 200);
        ArrayList<Items> arrayList = new ArrayList<Items>();
        arrayList.add(demo1);
        arrayList.add(demo2);


        final RecyclerView.Adapter adapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}