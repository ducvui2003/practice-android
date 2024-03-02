package com.example.event;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class List extends AppCompatActivity {
    private ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
    }

    private void init() {
        listView = findViewById(R.id.list);
        java.util.List<String> list = Arrays.asList(getResources().getStringArray(R.array.technology));
        adapter = new ArrayAdapter<>(this, R.layout.item, list);
        listView.setAdapter(adapter);
    }
}