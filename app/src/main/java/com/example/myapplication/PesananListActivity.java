package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class PesananListActivity extends AppCompatActivity {


    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.CUSTOMER_NAME, DatabaseHelper.JENIS_KERTAS, DatabaseHelper.WARNA, DatabaseHelper.JUMLAH_RANGKAP, DatabaseHelper.JUMLAH_PCS, DatabaseHelper.NOTE };

    final int[] to = new int[] { R.id.id, R.id.customer_name, R.id.jenis_kertas, R.id.warna, R.id.jumlah_rangkap, R.id.jumlah_pcs, R.id.note };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();


        Cursor cursor = dbManager.fetch();

        listView = findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);


        // KLIK ITEM DI LISTVIEW
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                String id = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper._ID));
                String customerName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.CUSTOMER_NAME));
                String selectedJenisKertas = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.JENIS_KERTAS));
                String selectedWarna = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.WARNA));
                String rangkap = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.JUMLAH_RANGKAP));
                String pcs = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.JUMLAH_PCS));
                String noteText = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.NOTE));




                Intent modify_intent = new Intent(getApplicationContext(), ModifyCountryActivity.class);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("customerName", customerName);
                modify_intent.putExtra("jenisKertas", selectedJenisKertas);
                modify_intent.putExtra("warna", selectedWarna);
                modify_intent.putExtra("jumlahRangkap", rangkap);
                modify_intent.putExtra("jumlahPcs", pcs);
                modify_intent.putExtra("note", noteText);

                startActivity(modify_intent);
            }
        });


    }


    public  void klikKembali(View v)
    {

        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
    }
}