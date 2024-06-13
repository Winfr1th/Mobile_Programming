package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyCountryActivity extends AppCompatActivity implements View.OnClickListener {
    private DBManager dbManager;
    EditText edNAme, edDesc;
    private long _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_country);
        dbManager = new DBManager(this);
        dbManager.open();
        edNAme = findViewById(R.id.editTextName);
        edDesc = findViewById(R.id.editTextDesc);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        _id = Long.parseLong(id);

        edNAme.setText(name);
        edDesc.setText(desc);


 
    }
    public void klikSimpan(View v)
    {
            String title = edNAme.getText().toString();
            String desc = edDesc.getText().toString();

            dbManager.update(_id, title, desc);
            Intent intent = new Intent(getApplicationContext(), CountryListActivity.class);
            startActivity(intent);
    }
    public void klikHapus(View v)
    {
        dbManager.delete(_id);
        Intent intent = new Intent(getApplicationContext(), CountryListActivity.class);
        startActivity(intent);
    }

    public void klikKembali(View v)
    {
        finish();
    }

    @Override
    public void onClick(View v) {

    }
}