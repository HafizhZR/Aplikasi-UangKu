package com.example.uangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ImageView;

    EditText et1, et2;
    Button btTambah, btKurang, btKali, btBagi;
    TextView tvHasil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        tvHasil = (TextView) findViewById(R.id.textView4);
        btTambah = (Button) findViewById(R.id.btnTambah);
        btKurang = (Button) findViewById(R.id.btnKurang);
        btKali = (Button) findViewById(R.id.btnKali);
        btBagi = (Button) findViewById(R.id.btnBagi);

        btTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, hasil;
                bil1 = Double.valueOf(et1.getText().toString().trim());
                bil2 = Double.valueOf(et2.getText().toString().trim());
                hasil = bil1 + bil2;
                String hasil1 = String.valueOf(hasil);
                tvHasil.setText(hasil1);
            }

        });

        btKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bil1, bil2, hasil;
                bil1 = Double.valueOf(et1.getText().toString().trim());
                bil2 = Double.valueOf(et2.getText().toString().trim());
                hasil = bil1 - bil2;
                String hasil1 = String.valueOf(hasil);
                tvHasil.setText(hasil1);
            }
        });

        btBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bil1, bil2, hasil;
                bil1 = Double.valueOf(et1.getText().toString().trim());
                bil2 = Double.valueOf(et2.getText().toString().trim());
                hasil = bil1/bil2;
                String hasil1 = String.valueOf(hasil);
                tvHasil.setText(hasil1);

            }
        });

        btKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bil1, bil2, hasil;
                bil1 = Double.valueOf(et1.getText().toString().trim());
                bil2 = Double.valueOf(et2.getText().toString().trim());
                hasil = bil1*bil2;
                String hasil1 = String.valueOf(hasil);
                tvHasil.setText(hasil1);
            }
        });

        // Credit



        ImageView = findViewById(R.id.icon_pemasukan);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent (MainActivity.this , TransaksiActivity.class));

            }
        } );

        ImageView = findViewById(R.id.icon_team);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent (MainActivity.this , Credit.class));

            }
        } );

        ImageView = findViewById(R.id.icon_credit);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent (MainActivity.this , Credit.class));

            }
        } );
        }
    }
