package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dbManager = new DBManager(this);
        dbManager.open();
        int jumlahData = dbManager.getRecordCount();
        TextView totalData = findViewById(R.id.total_data);
        totalData.setText(String.valueOf(jumlahData));
    }

    public void klikTampilkanData(View v)
    {
        Intent i = new Intent(getApplicationContext(), PesananListActivity.class);
        startActivity(i);
    }
    public void klikAddData(View v)
    {
        Intent i = new Intent(getApplicationContext(), TambahDataActivity.class);
        startActivity(i);
    }


}