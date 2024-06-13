//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.SimpleCursorAdapter;
//import android.widget.Toast;
//
//public class AddCountryActivity extends AppCompatActivity {
//
//    EditText etName, etDescription;
//    Button btSave, btBack;
//    private DBManager dbManager;
//
//    final int[] to = new int[] { R.id.id, R.id.title, R.id.desc };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_country);
//        etName = findViewById(R.id.etName);
//        etDescription = findViewById(R.id.etDescription);
//        btSave = findViewById(R.id.btSave);
//        btBack = findViewById(R.id.btBack);
//        dbManager = new DBManager(this);
//        dbManager.open();
//        btSave.setOnClickListener(v->{
//            String name = etName.getText().toString();
//            String description = etDescription.getText().toString();
//            if(name.isEmpty() || description.isEmpty()){
//            Toast.makeText(this, "Harap masukkan data secara lengkap!", Toast.LENGTH_SHORT).show();}
//            else{
//                dbManager.insert(name, description);
//                Toast.makeText(this, "Input Berhasil!", Toast.LENGTH_SHORT).show();
//            }
//    });
//        btBack.setOnClickListener(v -> finish());
//}}
