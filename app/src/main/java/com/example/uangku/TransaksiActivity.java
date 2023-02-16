package com.example.uangku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class TransaksiActivity extends AppCompatActivity {

    Calendar myCalendar;
    Button btn1, btn2;
    DatePickerDialog.OnDateSetListener date;
    EditText enominal, ejudul;
    Spinner spinnerType;

    TextView datedeparture, thasil, totalNominal;

    RecyclerView rvTransaksi;
    TransaksiAdapter transaksiAdapter;
    ArrayList<Transaksi> listTransaksi;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);


        rvTransaksi = (RecyclerView) findViewById(R.id.listTransaksi);
        listTransaksi = new ArrayList<Transaksi>();
        transaksiAdapter = new TransaksiAdapter(listTransaksi);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TransaksiActivity.this);
        rvTransaksi.setLayoutManager(layoutManager);
        rvTransaksi.setAdapter(transaksiAdapter);

        spinnerType = (Spinner) findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.transaction_type_array, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);

        btn1 = (Button) findViewById(R.id.buttonSimpan);
        btn2 = (Button) findViewById(R.id.buttonBatal);
        enominal = (EditText) findViewById(R.id.editNominal);
        ejudul = (EditText) findViewById(R.id.editJudul);
        datedeparture = findViewById(R.id.datedeparture);
        totalNominal = (TextView) findViewById(R.id.totalNominal);
        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.datedeparture);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalendar.getTime()));
            }
        };

        datedeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(TransaksiActivity.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();

                String type = ((Spinner) findViewById(R.id.spinner_type)).getSelectedItem().toString();
                String tanggal = ((TextView) findViewById(R.id.datedeparture)).getText().toString();
                String nominal = ((EditText) findViewById(R.id.editNominal)).getText().toString();
                String judul = ((EditText) findViewById(R.id.editJudul)).getText().toString();

                if ((type != null && type.length() > 0)
                        && (tanggal != null && tanggal.length() > 0)
                        && (nominal != null && nominal.length() > 0)
                        && (judul != null && judul.length() > 0)) {
                    if (!nominal.matches("[0-9]+")) {
                        CharSequence text = "Nominal memiliki karakter selain angka!";
                        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println(type.equals("Pemasukan"));
                        Transaksi formTransaksi = new Transaksi(type.equals("Pemasukan") ? 1 : 2,
                                Integer.parseInt(nominal), judul, tanggal);
                        listTransaksi.add(0, formTransaksi);
                        transaksiAdapter.notifyItemChanged(0);

                        totalNominal.setText(transaksiAdapter.getSumNominal()+"");
                    }
                } else {
                    CharSequence text = "Mohon isi data lengkap!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}

