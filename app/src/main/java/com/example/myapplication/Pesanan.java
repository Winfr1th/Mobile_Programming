package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Pesanan implements Parcelable {
    private String customerName, jenisKertas, warna, note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id, jumlahRangkap, jumlahPcs;

    public Pesanan(int id, String customerName, String jenisKertas, String warna, String note, int jumlahRangkap, int jumlahPcs) {
        this.id = id;
        this.customerName = customerName;
        this.jenisKertas = jenisKertas;
        this.warna = warna;
        this.note = note;
        this.jumlahRangkap = jumlahRangkap;
        this.jumlahPcs = jumlahPcs;
    }

    protected Pesanan(Parcel in) {
        id = in.readInt();
        customerName = in.readString();
        jenisKertas = in.readString();
        warna = in.readString();
        note = in.readString();
        jumlahRangkap = in.readInt();
        jumlahPcs = in.readInt();
    }

    public static final Creator<Pesanan> CREATOR = new Creator<Pesanan>() {
        @Override
        public Pesanan createFromParcel(Parcel in) {
            return new Pesanan(in);
        }

        @Override
        public Pesanan[] newArray(int size) {
            return new Pesanan[size];
        }
    };

    public String getCustomerName() {
        return customerName;
    }

    public String getJenisKertas() {
        return jenisKertas;
    }

    public String getWarna() {
        return warna;
    }

    public String getNote() {
        return note;
    }

    public int getJumlahRangkap() {
        return jumlahRangkap;
    }

    public int getJumlahPcs() {
        return jumlahPcs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(jenisKertas);
        dest.writeString(warna);
        dest.writeString(note);
        dest.writeInt(jumlahRangkap);
        dest.writeInt(jumlahPcs);
    }
}
