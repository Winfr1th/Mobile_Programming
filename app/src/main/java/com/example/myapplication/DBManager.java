package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String customerName, String jenisKertas, String warna, int jumlahRangkap, int jumlahPcs, String note) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.CUSTOMER_NAME, customerName);
        contentValue.put(DatabaseHelper.JENIS_KERTAS, jenisKertas);
        contentValue.put(DatabaseHelper.WARNA, warna);
        contentValue.put(DatabaseHelper.JUMLAH_RANGKAP, jumlahRangkap);
        contentValue.put(DatabaseHelper.JUMLAH_PCS, jumlahPcs);
        contentValue.put(DatabaseHelper.NOTE, note);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.CUSTOMER_NAME, DatabaseHelper.JENIS_KERTAS, DatabaseHelper.WARNA, DatabaseHelper.JUMLAH_RANGKAP, DatabaseHelper.JUMLAH_PCS, DatabaseHelper.NOTE };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String customerName, String jenisKertas, String warna, int jumlahRangkap, int jumlahPcs, String note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.CUSTOMER_NAME, customerName);
        contentValues.put(DatabaseHelper.JENIS_KERTAS, jenisKertas);
        contentValues.put(DatabaseHelper.WARNA, warna);
        contentValues.put(DatabaseHelper.JUMLAH_RANGKAP, jumlahRangkap);
        contentValues.put(DatabaseHelper.JUMLAH_PCS, jumlahPcs);
        contentValues.put(DatabaseHelper.NOTE, note);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }
    public int getRecordCount() {
        String countQuery = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;
        Cursor cursor = database.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
}
