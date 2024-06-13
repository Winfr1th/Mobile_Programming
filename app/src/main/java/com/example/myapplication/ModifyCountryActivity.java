package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class ModifyCountryActivity extends AppCompatActivity implements View.OnClickListener {
    private DBManager dbManager;
    EditText edCustomerName, edUploadFile, edJumlahRangkap, edJumlahPcs, edNote;
    private Spinner spinnerJenisKertas, spinnerWarna;
    private ImageView imageView;
    private static final int PICK_IMAGE_REQUEST = 1;
    private long _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_country);
        dbManager = new DBManager(this);
        dbManager.open();
        edCustomerName = findViewById(R.id.editTextName);
        spinnerJenisKertas = findViewById(R.id.spinnerKertas);
        spinnerWarna = findViewById(R.id.spinnerWarna);
        edJumlahRangkap = findViewById(R.id.editTextNumberRangkap);
        edJumlahPcs = findViewById(R.id.editTextNumberPcs);
        edNote = findViewById(R.id.editTextNote);
//        imageView = findViewById(R.id.imageView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open image picker when ImageView is clicked
//                openImagePicker();
//            }
//        });

        ArrayAdapter<CharSequence> adapterJenisKertas = ArrayAdapter.createFromResource(this, R.array.jenis_kertas, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterWarna = ArrayAdapter.createFromResource(this, R.array.warna, android.R.layout.simple_spinner_item);
        adapterJenisKertas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenisKertas.setAdapter(adapterJenisKertas);
        adapterWarna.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWarna.setAdapter(adapterWarna);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String customerName = intent.getStringExtra("customerName");
        String jenisKertas = intent.getStringExtra("jenisKertas");
        String warna = intent.getStringExtra("warna");
        String jumlahRangkap = intent.getStringExtra("jumlahRangkap");
        String jumlahPcs = intent.getStringExtra("jumlahPcs");
        String note = intent.getStringExtra("note");

        _id = Long.parseLong(id);

        edCustomerName.setText(customerName);
        int jenisKertasPosition = adapterJenisKertas.getPosition(jenisKertas);
        spinnerJenisKertas.setSelection(jenisKertasPosition);

        int warnaPosition = adapterWarna.getPosition(warna);
        spinnerWarna.setSelection(warnaPosition);

        edJumlahRangkap.setText(jumlahRangkap);
        edJumlahPcs.setText(jumlahPcs);
        edJumlahRangkap.setText(jumlahRangkap);
        edJumlahPcs.setText(jumlahPcs);
        edNote.setText(note);


 
    }
    public void klikSimpan(View v)
    {
        String customerName = edCustomerName.getText().toString();
        String jenisKertas = spinnerJenisKertas.getSelectedItem().toString();
        String warna = spinnerWarna.getSelectedItem().toString();
        int jumlahRangkap = Integer.parseInt(edJumlahRangkap.getText().toString());
        int jumlahPcs = Integer.parseInt(edJumlahPcs.getText().toString());
        String note = edNote.getText().toString();

        dbManager.update(_id, customerName, jenisKertas, warna, jumlahRangkap, jumlahPcs, note);
            Intent intent = new Intent(getApplicationContext(), PesananListActivity.class);
            startActivity(intent);
    }
    public void klikHapus(View v)
    {
        dbManager.delete(_id);
        Intent intent = new Intent(getApplicationContext(), PesananListActivity.class);
        startActivity(intent);
    }

    public void klikKembali(View v)
    {

        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}