package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TambahDataActivity extends AppCompatActivity {

    private DBManager dbManager;

    EditText edCustomerName, edUploadFile, edJumlahRangkap, edJumlahPcs, edNote;
    private Spinner spinnerJenisKertas, spinnerWarna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        edCustomerName = findViewById(R.id.editTextName);
        spinnerJenisKertas = findViewById(R.id.spinnerKertas);
        spinnerWarna = findViewById(R.id.spinnerWarna);
        edJumlahRangkap = findViewById(R.id.editTextNumberRangkap);
        edJumlahPcs = findViewById(R.id.editTextNumberPcs);
        edNote = findViewById(R.id.editTextNote);
        ArrayAdapter<CharSequence> adapterJenisKertas = ArrayAdapter.createFromResource(this, R.array.jenis_kertas, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterWarna = ArrayAdapter.createFromResource(this, R.array.warna, android.R.layout.simple_spinner_item);
        adapterJenisKertas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenisKertas.setAdapter(adapterJenisKertas);
        adapterWarna.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWarna.setAdapter(adapterWarna);
    }

    public void klikSimpan(View v)
    {
        dbManager = new DBManager(this);
        dbManager.open();

        String customerName = edCustomerName.getText().toString();
        String jenisKertas = spinnerJenisKertas.getSelectedItem().toString();
        String warna = spinnerWarna.getSelectedItem().toString();
        int jumlahRangkap = Integer.parseInt(edJumlahRangkap.getText().toString());
        int jumlahPcs = Integer.parseInt(edJumlahPcs.getText().toString());
        String note = edNote.getText().toString();

        dbManager.insert(customerName, jenisKertas, warna, jumlahRangkap, jumlahPcs, note);
    }

    public void klikKembali(View v)
    {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}