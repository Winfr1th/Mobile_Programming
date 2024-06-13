package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TambahDataActivity extends AppCompatActivity {

    private DBManager dbManager;

    EditText edNAme, edDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        edNAme = findViewById(R.id.editTextName);
        edDesc = findViewById(R.id.editTextDesc);

    }

    public void klikSimpan(View v)
    {
        dbManager = new DBManager(this);
        dbManager.open();

        String name = edNAme.getText().toString();
        String desc = edDesc.getText().toString();

        dbManager.insert(name, desc);
    }

    public void klikKembali(View v)
    {
        finish();
    }
}