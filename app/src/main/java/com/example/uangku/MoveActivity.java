package com.example.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        TextView tvData = findViewById(R.id.tv_data);

        Intent dataIntent = getIntent();

        String data = dataIntent.getStringExtra("data");

        if (data.equals("")) {
            data = "Tidak Memasukkan Data";
        }
        tvData.setText(data);
    }
}