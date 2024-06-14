package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.ViewHolder> {
    private ArrayList<Pesanan> pesanans;
    private OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public PesananAdapter(ArrayList<Pesanan> pesanans){
        this.pesanans = pesanans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pesanan pesanan = pesanans.get(position);

        holder.tvCustomerName.setText(pesanan.getCustomerName());
        holder.tvJenisKertas.setText(pesanan.getJenisKertas());
        holder.tvWarna.setText(pesanan.getWarna());
        holder.tvJumlahRangkap.setText(String.valueOf(pesanan.getJumlahRangkap()));
        holder.tvJumlahPcs.setText(String.valueOf(pesanan.getJumlahPcs()));
        holder.tvNote.setText(pesanan.getNote());
    }

    @Override
    public int getItemCount() {
        return pesanans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCustomerName, tvJenisKertas, tvWarna, tvJumlahRangkap, tvJumlahPcs, tvNote;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvCustomerName = itemView.findViewById(R.id.customer_name);
            tvJenisKertas = itemView.findViewById(R.id.jenis_kertas);
            tvWarna = itemView.findViewById(R.id.warna);
            tvJumlahRangkap = itemView.findViewById(R.id.jumlah_rangkap);
            tvJumlahPcs = itemView.findViewById(R.id.jumlah_pcs);
            tvNote = itemView.findViewById(R.id.note);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
