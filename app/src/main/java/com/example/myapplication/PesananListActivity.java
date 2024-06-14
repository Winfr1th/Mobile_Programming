package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;



public class PesananListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PesananAdapter adapter;
    private ArrayList<Pesanan> pesananList;
    private DBManager dbManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pesananList = new ArrayList<>();

        dbManager = new DBManager(this);
        dbManager.open();

        fetchPesanans();

        adapter = new PesananAdapter(pesananList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PesananAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Pesanan pesanan = pesananList.get(position);
                Intent intent = new Intent(getApplicationContext(), ModifyPesananActivity.class);
                intent.putExtra("id", String.valueOf(pesanan.getId()));
                intent.putExtra("customerName", pesanan.getCustomerName());
                intent.putExtra("jenisKertas", pesanan.getJenisKertas());
                intent.putExtra("warna", pesanan.getWarna());
                intent.putExtra("jumlahRangkap", String.valueOf(pesanan.getJumlahRangkap()));
                intent.putExtra("jumlahPcs", String.valueOf(pesanan.getJumlahPcs()));
                intent.putExtra("note", pesanan.getNote());
                startActivity(intent);
            }
        });
    }

    private void fetchPesanans() {
        Cursor cursor = dbManager.fetch();
        if (cursor.moveToFirst()) {
            do {
                Pesanan pesanan = new Pesanan(
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.CUSTOMER_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.JENIS_KERTAS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.WARNA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.NOTE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.JUMLAH_RANGKAP)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.JUMLAH_PCS))
                );
                pesananList.add(pesanan);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }


    public  void klikKembali(View v)
    {

        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}