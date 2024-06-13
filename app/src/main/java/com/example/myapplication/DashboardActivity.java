package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void klikTampilkanData(View v)
    {
        Intent i = new Intent(getApplicationContext(), CountryListActivity.class);
        startActivity(i);
    }
    public void klikAddData(View v)
    {
        Intent i = new Intent(getApplicationContext(), TambahDataActivity.class);
        startActivity(i);
    }


}