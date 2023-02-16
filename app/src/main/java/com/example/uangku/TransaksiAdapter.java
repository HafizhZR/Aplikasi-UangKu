package com.example.uangku;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.TransaksiViewHolder> {

    private ArrayList<Transaksi> dataList;

    public TransaksiAdapter(ArrayList<Transaksi> dataList) {
        this.dataList = dataList;
    }

    @Override
    public TransaksiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_adapter_item, parent, false);
        return new TransaksiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransaksiViewHolder holder, int position) {
        holder.tvTanggal.setText(dataList.get(position).getTanggal());
        holder.tvJudul.setText(dataList.get(position).getJudul());

        holder.tvNominal.setText(dataList.get(position).getNominal()+"");
        if (dataList.get(position).getType() == 2) {
            holder.tvNominal.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public int getSumNominal() {
        int total = 0;
        for (Transaksi t : dataList) {
            if (t.getType() == 1) total += t.getNominal();
            else total -= t.getNominal();
        }

        return total;
    }

    public class TransaksiViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTanggal, tvJudul, tvNominal;

        public TransaksiViewHolder(View itemView) {
            super(itemView);
            tvTanggal = (TextView) itemView.findViewById(R.id.tanggal);
            tvJudul = (TextView) itemView.findViewById(R.id.judul);
            tvNominal = (TextView) itemView.findViewById(R.id.nominal);
        }
    }
}
