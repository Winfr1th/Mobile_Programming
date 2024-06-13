package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper{

    // Table Name
    public static final String TABLE_NAME = "PESANAN";

    // Table columns
    public static final String _ID = "_id";
    public static final String CUSTOMER_NAME = "customer_name";
    public static final String UPLOAD_FILE = "upload_file";
    public static final String JENIS_KERTAS = "jenis_kertas";
    public static final String WARNA = "warna";
    public static final String JUMLAH_RANGKAP = "jumlah_rangkap";
    public static final String JUMLAH_PCS = "jumlah_pcs";
    public static final String NOTE = "note";
    // Database Information
    static final String DB_NAME = "UAS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " TEXT NOT NULL, " + JENIS_KERTAS + " TEXT NOT NULL," + WARNA  + " TEXT NOT NULL, " + JUMLAH_RANGKAP + " INTEGER, " + JUMLAH_PCS + " INTEGER, " + NOTE + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
