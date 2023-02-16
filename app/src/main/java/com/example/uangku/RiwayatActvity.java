package com.example.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class RiwayatActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_riwayat_keuangan);

        TextView EditNominal = findViewById(R.id.tvdatapendapat);

        Intent dataIntent = getIntent();

        String data = dataIntent.getStringExtra("data");

        if (data.equals("")) {
            data = "Tidak Memasukkan Data";
        }
        EditNominal.setText(data);
    }
}